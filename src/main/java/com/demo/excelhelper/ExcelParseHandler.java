package com.demo.excelhelper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 */
public class ExcelParseHandler<T> {


    public List<T> doParse(InputStream inputStream, Class<T> tClass) throws Exception {

        Workbook wb = null;

        List<T> rowList = new ArrayList<>();

        try {

            wb = WorkbookFactory.create(inputStream);

            Sheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }


                List<String> cellList = new ArrayList<>();

                for (Cell cell : row) {

                    String cellValue = "";

                    cellValue = getCellString(cell, cellValue);

                    cellList.add(cellValue);

                }

                T obj = tClass.newInstance();

                Field[] fields = obj.getClass().getDeclaredFields();

                for (Field field : fields) {

                    if (field.isAnnotationPresent(ExcelFiled.class)) {

                        ExcelFiled excelFiled = field.getAnnotation(ExcelFiled.class);

                        if (!excelFiled.isRead()) {
                            continue;
                        }

                        field.setAccessible(true);
                        field.set(obj, cellList.get(excelFiled.index()));

                    }
                }

                rowList.add(obj);

            }


        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (wb != null) {
                wb.close();
            }
        }

        return rowList;
    }

    public void doWriteBook(String fileName, List<T> bookList) throws Exception {


        Workbook wb = new XSSFWorkbook();

        try {

            Sheet sheet = wb.createSheet("Sheet");

            int num = 0;

            T t1 = bookList.get(0);

            Field[] headFields = t1.getClass().getDeclaredFields();

            Row headRow = sheet.createRow(0);

            for (Field field : headFields) {

                if (field.isAnnotationPresent(ExcelFiled.class)) {
                    ExcelFiled excelFiled = field.getAnnotation(ExcelFiled.class);
                    field.setAccessible(true);
                    int index = excelFiled.index();
                    Cell cell = headRow.createCell(index);
                    Font font = wb.createFont();
                    font.setBold(true);
                    CellStyle cellStyle01 = wb.createCellStyle();
                    cellStyle01.setFont(font);
                    cell.setCellStyle(cellStyle01);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue(field.getName().toUpperCase());
                }

            }

            num++;

            for (T t : bookList) {

                Field[] fields = t.getClass().getDeclaredFields();

                Row row = sheet.createRow(num);

                for (Field field : fields) {

                    if (field.isAnnotationPresent(ExcelFiled.class)) {

                        ExcelFiled excelFiled = field.getAnnotation(ExcelFiled.class);
                        field.setAccessible(true);
                        int index = excelFiled.index();
                        Cell cell = row.createCell(index);

                        CellStyle cellStyle01 = wb.createCellStyle();
                        cell.setCellStyle(cellStyle01);
                        cell.setCellType(CellType.STRING);

                        Object value = field.get(t);

                        String type = field.getGenericType().toString();

                        if (type.equals("boolean")) {
                            CellStyle cellStyle = wb.createCellStyle();
                            cellStyle.setBorderBottom(BorderStyle.THIN);
                            cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                            cellStyle.setBorderLeft(BorderStyle.THIN);
                            cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                            cellStyle.setBorderRight(BorderStyle.THIN);
                            cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
                            cellStyle.setBorderTop(BorderStyle.THIN);
                            cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                            cellStyle.setAlignment(HorizontalAlignment.CENTER);
                            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                            if ((boolean)value){
                                cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                            }else {
                                cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                            }
                            cell.setCellStyle(cellStyle);
                            cell.setCellValue((boolean)value);
                            continue;
                        }


                        cell.setCellValue((String) value);

                    }
                }

                sheet.autoSizeColumn(num, true);
                num++;
            }

            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {

                wb.write(fileOut);
            }

        } finally {

            wb.close();
        }

    }

 private  static String getCellString(Cell cell, String cellValue) {

        switch (cell.getCellTypeEnum()) {
            case STRING:
                cellValue = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    cellValue = cell.getDateCellValue().toString();
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case BLANK:
                break;
            default:
        }
        return cellValue;
    }

}

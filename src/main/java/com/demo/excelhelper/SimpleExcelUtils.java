package com.demo.excelhelper;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 */
public class SimpleExcelUtils {

    public static void main(String[] args) throws Exception {

        List<List<String>> strList = readBook("CustBuyInfo.xlsx");

        list2Array(strList);

        for (Object[] array:list2Array(strList)){
            for (String str:(String[]) array){
                System.out.println(str);
            }
        }

    }

    public static Object[][] readBook2Array(String fileName) throws Exception{
        return list2Array(readBook(fileName));
    }

    public static List<List<String>> readBook(String fileName) throws IOException, InvalidFormatException {
        return readBook(new FileInputStream(fileName));
    }


    public static List<List<String>> readBook(InputStream inputStream) throws IOException, InvalidFormatException {

        Workbook wb = null;

        List<List<String>> rowsList = new ArrayList<>();

        try {

            wb = WorkbookFactory.create(inputStream);

            Sheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {

                List<String> cellList = new ArrayList<>();

                if (row.getRowNum() == 0) {
                    continue;
                }

                for (Cell cell : row) {

                    String cellValue = "";

                    cellValue = SimpleExcelUtils.getCellString(cell, cellValue);

                    cellList.add(cellValue);

                }

                rowsList.add(cellList);
            }


        } finally {

            if (wb != null) {
                wb.close();
            }
        }

        return rowsList;
    }


    public static void writeBook(String fileName, List<List<String>> bookList) throws Exception{

        InputStream inp = null;

        Workbook wb = null;

        List<List<String>> rowsList = new ArrayList<>();

        try {
            inp = new FileInputStream(fileName);

            wb = WorkbookFactory.create(inp);

            Sheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {

                List<String> cellList = new ArrayList<>();

                if (row.getRowNum() == 0) {
                    continue;
                }

                for (Cell cell : row) {

                    String cellValue = "";

                    if (cell.getColumnIndex() == row.getLastCellNum()-1) {
                        CellStyle cellStyle = wb.createCellStyle();
                        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                        cellStyle.setBorderBottom(BorderStyle.THIN);
                        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                        cellStyle.setBorderLeft(BorderStyle.THIN);
                        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                        cellStyle.setBorderRight(BorderStyle.THIN);
                        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
                        cellStyle.setBorderTop(BorderStyle.THIN);
                        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                        cellStyle.setAlignment(HorizontalAlignment.CENTER);
                        cell.setCellStyle(cellStyle);
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue("FALSE");
                    }
                    cellValue = SimpleExcelUtils.getCellString(cell, cellValue);

                    cellList.add(cellValue);

                }
                rowsList.add(cellList);
            }

            try (FileOutputStream fileOut = new FileOutputStream("test1.xlsx")) {
                wb.write(fileOut);
            }

        } finally {

            if (inp != null) {
                inp.close();
            }

            if (wb != null) {
                wb.close();
            }
        }

    }

   static String getCellString(Cell cell, String cellValue) {

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


    public static Object[][] list2Array(List<List<String>> outerList){

        Object[][] outerArray = new String[outerList.size()][];

        int i=0;
        for(List<String> innerList:outerList){
            String[] innerArray = innerList.toArray(new String[innerList.size()]);
            outerArray[i]=innerArray;
            i++;
        }
        return outerArray;
    }
}

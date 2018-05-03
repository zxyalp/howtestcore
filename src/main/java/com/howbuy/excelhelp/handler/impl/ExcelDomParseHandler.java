package com.howbuy.excelhelp.handler.impl;

import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.meta.ExcelField;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author yang.zhou
 * @date 2018/4/27
 */
public class ExcelDomParseHandler<T> extends BaseExcelParseHandle<T> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<T> process(IParseParam parseParam) throws Exception {

        Workbook wb = getWorkBook(parseParam);

        Sheet sheet = wb.getSheetAt(parseParam.getSheetNum());

        Iterator<Row> rowIterator = sheet.rowIterator();

        if (parseParam.getHeader() != null && parseParam.getHeader().size() != 0) {
            checkHeader(rowIterator, parseParam);
        }
        return parseRowToTargetList(rowIterator, parseParam);
    }


    @Override
    public void writeProcess(IParseParam parseParam, List<T> excelList) throws Exception {

        Workbook wb = new XSSFWorkbook();

        try {

            Sheet sheet = wb.createSheet();

            int line = 0;

            if (parseParam.getHeader() != null && parseParam.getHeader().size() != 0) {
                Row header = sheet.createRow(line);

                List<String> headerData = parseParam.getHeader();

                for (int index = 0; index < headerData.size(); index++) {
                    Cell cell = header.createCell(index);
                    Font font = wb.createFont();
                    font.setBold(true);
                    CellStyle cellStyle01 = wb.createCellStyle();
                    cellStyle01.setFont(font);
                    cell.setCellStyle(cellStyle01);
                    cell.setCellType(CellType.STRING);
                    cell.setCellValue(headerData.get(index));
                }
                line++;
            }

            for (T t : excelList) {

                Field[] fields = t.getClass().getDeclaredFields();

                Row row = sheet.createRow(line++);

                for (Field field : fields) {

                    if (field.isAnnotationPresent(ExcelField.class)) {

                        ExcelField excelFiled = field.getAnnotation(ExcelField.class);
                        field.setAccessible(true);
                        int index = excelFiled.index();
                        Cell cell = row.createCell(index);

                        CellStyle cellStyle01 = wb.createCellStyle();
                        cell.setCellStyle(cellStyle01);
                        cell.setCellType(CellType.STRING);

                        String fieldValue = field.get(t).toString();

                        if (excelFiled.isResult()) {
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

                            if ("success".equalsIgnoreCase(fieldValue) || "true".equalsIgnoreCase(fieldValue)) {
                                cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
                            } else {
                                cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
                            }
                            cell.setCellStyle(cellStyle);
                            cell.setCellValue(fieldValue);
                            continue;
                        }
                        cell.setCellValue(fieldValue);
                        sheet.autoSizeColumn(index, true);
                    }
                }
            }

            try (OutputStream fileOut = parseParam.getExcelOutputStream()) {

                wb.write(fileOut);
            }

        } finally {

            wb.close();
        }
    }


    private List<T> parseRowToTargetList(Iterator<Row> rowIterator, IParseParam parseParam) {
        List<T> result = new ArrayList<>();
        for (; rowIterator.hasNext(); ) {
            Row row = rowIterator.next();
            List<String> rowData = parseRowToList(row, parseParam.getColumnSize());
            Optional<T> d = parseRowToTarget(parseParam, rowData);
            d.ifPresent(result::add);
        }
        return result;
    }

    private Workbook getWorkBook(IParseParam parseParam) throws Exception {

        return WorkbookFactory.create(parseParam.getExcelInputStream());
    }


    private List<String> parseRowToList(Row row, int size) {

        List<String> dataRow = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            if (row.getCell(i) != null) {
                DataFormatter formatter = new DataFormatter();
                String formatterCellValue = formatter.formatCellValue(row.getCell(i));
                dataRow.add(formatterCellValue.trim());
            } else {
                dataRow.add("");
            }
        }
        return dataRow;
    }


    private void checkHeader(Iterator<Row> rowIterator, IParseParam parseParam) {
        while (true) {
            Row row = rowIterator.next();
            List<String> rowData = parseRowToList(row, parseParam.getColumnSize());
            boolean empty = isRowDataEmpty(rowData);
            if (!empty) {
                validHeader(parseParam, rowData);
                break;
            }
        }
    }

}

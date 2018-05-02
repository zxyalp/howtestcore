package com.howbuy.excelhelp.handler.impl;

import com.howbuy.excelhelp.IParseParam;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public List<T> process(IParseParam parseParam) throws Exception{

        Workbook wb = getWorkBook(parseParam);

        Sheet sheet = wb.getSheetAt(parseParam.getSheetNum());

        Iterator<Row> rowIterator = sheet.rowIterator();

        if (parseParam.getHeader() != null && parseParam.getHeader().size() != 0){
            checkHeader(rowIterator, parseParam);
        }
        return parseRowToTargetList(rowIterator, parseParam);
    }


    @Override
    public void writeProcess(IParseParam parseParam, List<T> excelList) throws Exception {
        Workbook wb = getWorkBook(parseParam);
        Sheet sheet = wb.createSheet();

    }

    private List<T> parseRowToTargetList(Iterator<Row> rowIterator, IParseParam parseParam){
        List<T> result = new ArrayList<>();
        for (; rowIterator.hasNext(); ){
            Row row = rowIterator.next();
            List<String> rowData = parseRowToList(row,parseParam.getColumnSize());
            Optional<T> d = parseRowToTarget(parseParam, rowData);
            d.ifPresent(result::add);
        }
        return result;
    }

    private Workbook getWorkBook(IParseParam parseParam) throws Exception{

        return WorkbookFactory.create(parseParam.getExcelInputStream());
    }


    private List<String> parseRowToList(Row row, int size){

        List<String> dataRow = new ArrayList<>(size);

        for (int i=0; i<size; i++) {
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


    private void checkHeader(Iterator<Row> rowIterator, IParseParam parseParam){
        while (true){
            Row row = rowIterator.next();
            List<String> rowData = parseRowToList(row, parseParam.getColumnSize());
            boolean empty = isRowDataEmpty(rowData);
            if (!empty){
                validHeader(parseParam, rowData);
                break;
            }
        }
    }

}

package com.demo;

import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @author yang.zhou
 * @date 2018/4/3
 */
public class ExcelDemo {
    private XSSFSheet sheet;
    private XSSFWorkbook workbook;
    private XSSFCell cell;
    private XSSFRow row;
    private String filePath;

    public ExcelDemo(String Path, String SheetName) throws Exception {

        FileInputStream excelFile;
        try {
            excelFile = new FileInputStream(Path);

            workbook = new XSSFWorkbook(excelFile);
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) throws Exception {

//         book97();
//        readCell();
        readForCell();

    }

    public static void booktest() throws Exception {
        Workbook excel97 = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("demo.xls");

        excel97.write(fileOut);

        fileOut.close();

        Workbook excel07 = new XSSFWorkbook();
        fileOut = new FileOutputStream("demox.xlsx");

        excel07.write(fileOut);

        fileOut.close();
    }

    public static void book97() throws Exception {
        Workbook wb = new XSSFWorkbook();

        CreationHelper creationHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");
        Sheet sheet1 = wb.createSheet("sheet1");
        String name = WorkbookUtil.createSafeSheetName("[*new sheet2/]");
        Sheet sheet2 = wb.createSheet(name);
        Row row = sheet.createRow((short) 0);
        Cell cell = row.createCell(0);
        cell.setCellValue(1);
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(creationHelper.createRichTextString("This is a test"));
        row.createCell(3).setCellValue(true);

        Row row1 = sheet.createRow(1);

        CellStyle cellStyle = wb.createCellStyle();

        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("m/d/yy h:mm"));

        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());

        Cell cell1 = row1.createCell(1);
        cell1.setCellValue(new Date());
        cell1.setCellStyle(cellStyle);

        cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell10 = row1.createCell(0);
        cell10.setCellValue("foot bar");
        cell10.setCellStyle(cellStyle);

        cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Cell cell11 = row1.createCell(7);
        cell11.setCellValue("False");
        cell11.setCellStyle(cellStyle);

        cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Cell cell12 = row1.createCell(8);
        cell12.setCellValue("True");
        cell12.setCellStyle(cellStyle);

        row1.createCell(2).setCellValue(Calendar.getInstance());
        row1.createCell(3).setCellType(CellType.ERROR);

        Cell cell2 = row1.createCell(1);
        cell2.setCellValue(4);

        // Style the cell with borders all around.
        CellStyle style = wb.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style.setBorderTop(BorderStyle.MEDIUM_DASHED);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        cell2.setCellStyle(style);

        Header header = sheet.getHeader();
        header.setCenter("Center Header");
        header.setLeft("Left Header");
        header.setRight(HSSFHeader.font("Stencil-Normal", "Italic") +
                HSSFHeader.fontSize((short) 16) + "Right w/ Stencil-Normal Italic font and size 16");

        FileOutputStream fileOut = new FileOutputStream("demo02.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }


    public static void readCell() throws Exception {
        InputStream inp = null;

        try {
            inp = new FileInputStream("test.xlsx");
            Workbook wb = WorkbookFactory.create(inp);

            Sheet sheet = wb.getSheetAt(0);

            Iterator<Row> rowIterable = sheet.rowIterator();

            while (rowIterable.hasNext()) {
                Row r = rowIterable.next();
                if (r == null) {
                    System.out.println("Empty Row");
                    continue;
                }

                for (int i = r.getFirstCellNum(); i < r.getLastCellNum(); i++) {
                    Cell cell = r.getCell(i);
                    String cellValue = "";

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

                    System.out.println("CellNum:" + i + "=>CellValue:" + cellValue);
                }
            }


        } finally {

            if (inp != null) {
                inp.close();
            }
        }


    }

    public static void readForCell() throws Exception {

        InputStream inp = null;
        Workbook wb = null;

        List<String> title = null;

        List<List<String>> rowsList = new ArrayList<>();

        try {
            inp = new FileInputStream("test.xlsx");
            wb = WorkbookFactory.create(inp);

            Sheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {

                title = new ArrayList<>();
                List<String> rowList = new ArrayList<>();

                for (Cell cell : row) {

                    String cellValue = "";

                    if (cell.getColumnIndex() == 11) {
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

                    if (row.getRowNum() == 0) {
                        title.add(cellValue);
                    }

                    rowList.add(cellValue);

                    System.out.println("CellNum:" + cell.getColumnIndex() + "=>CellValue:" + cellValue);
                }

                rowsList.add(rowList);
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
}

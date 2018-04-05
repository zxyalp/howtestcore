package com.demo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

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

    public ExcelDemo(String Path, String SheetName) throws Exception{

        FileInputStream excelFile;
        try {
            excelFile = new FileInputStream(Path);

            workbook = new XSSFWorkbook(excelFile);
        }


    }


}

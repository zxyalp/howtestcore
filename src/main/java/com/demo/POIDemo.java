package com.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * @author yang.zhou
 * @date 2018/4/3
 */
public class POIDemo {

    public static void main(String[] args) throws Exception {

        // xls
        Workbook excel1997 = new HSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("demo1997.xls");
        excel1997.write(fileOut);
        excel1997.close();

        // xlsx
        Workbook excel2007 = new XSSFWorkbook();
        FileOutputStream fileOut01 = new FileOutputStream("demo2007.xlsx");
        excel2007.write(fileOut01);
        excel2007.close();
    }
}

package com.howbuy.excelhelp;

import java.io.InputStream;
import java.util.List;

/**
 * @author yang.zhou
 */
public interface IParseParam {

    Integer FIRST_SHEET_NAME=0;

    InputStream getExcelInputStream();

    Class getTargetClass();

    Integer getColumnSize();

    Integer getSheetNum();

    List<String> getHeader();

}

package com.howbuy.excelhelp;

import java.io.InputStream;
import java.util.List;

public interface IParseParam {

    Integer FISRT_SHEET_NAME=0;

    InputStream getExcelInputStream();

    Class getTargetClass();

    Integer getColumnSize();

    Integer getSheetNum();

    List<String> getHeader();

}

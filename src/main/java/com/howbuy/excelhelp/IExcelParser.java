package com.howbuy.excelhelp;

import java.util.List;

public interface IExcelParser<T> {

    List<T> parse(IParseParam paraserParam);

}

package com.howbuy.excelhelp;

import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/05/02
 */
public interface IExcelParser<T> {

    List<T> parse(IParseParam parseParam);

    void write(IParseParam parseParam, List<T> excelList);

}

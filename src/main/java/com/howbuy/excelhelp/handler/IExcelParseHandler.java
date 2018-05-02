package com.howbuy.excelhelp.handler;

import com.howbuy.excelhelp.IParseParam;

import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/27
 */
public interface IExcelParseHandler<T> {

    List<T> process(IParseParam parseParam) throws Exception;

    void writeProcess(IParseParam parseParam, List<T> excelList) throws Exception;

}

package com.howbuy.excelhelp.paraser;

import com.howbuy.excelhelp.handler.impl.ExcelDomParseHandler;
import com.howbuy.excelhelp.handler.IExcelParaseHandler;

import java.io.InputStream;

/**
 * @author yang.zhou
 * @date 2018/4/27
 */
public class ExcelDomParser<T> extends AbstractExcelParser<T>{

    private IExcelParaseHandler<T> excelParseHandler;

    public ExcelDomParser(){

        this.excelParseHandler = new ExcelDomParseHandler<>();
    }

    @Override
    protected IExcelParaseHandler<T> createHandler(InputStream excelInputStream) {
        return this.excelParseHandler;
    }
}

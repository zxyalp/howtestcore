package com.howbuy.excelhelp.paraser;

import com.howbuy.excelhelp.handler.impl.ExcelDomParseHandler;
import com.howbuy.excelhelp.handler.IExcelParseHandler;

/**
 * @author yang.zhou
 * @date 2018/4/27
 */
public class ExcelDomParser<T> extends AbstractExcelParser<T> {

    private IExcelParseHandler<T> excelParseHandler;

    public ExcelDomParser() {

        this.excelParseHandler = new ExcelDomParseHandler<>();
    }

    @Override
    protected IExcelParseHandler<T> createHandler() {
        return this.excelParseHandler;
    }
}

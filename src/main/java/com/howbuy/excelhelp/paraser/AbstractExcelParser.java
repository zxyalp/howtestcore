package com.howbuy.excelhelp.paraser;

import com.howbuy.excelhelp.IExcelParser;
import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.handler.IExcelParseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/27
 */
abstract class AbstractExcelParser<T> implements IExcelParser<T> {

    Logger logger = LoggerFactory.getLogger(AbstractExcelParser.class);

    @Override
    public List<T> parse(IParseParam parseParam){

        IExcelParseHandler<T> handler = this.createHandler();

        try {
            return handler.process(parseParam);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void write(IParseParam parseParam, List<T> excelList) {
        IExcelParseHandler<T> handler = this.createHandler();
        try {
            handler.writeProcess(parseParam, excelList);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * create ExcelParseHandler
     * @return IExcelParseHandler<T>
     */
    protected abstract IExcelParseHandler<T> createHandler();



}

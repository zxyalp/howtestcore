package com.howbuy.excelhelp.paraser;

import com.howbuy.excelhelp.IExcelParser;
import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.handler.IExcelParaseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/27
 */
abstract class AbstractExcelParser<T> implements IExcelParser<T> {

    Logger logger = LoggerFactory.getLogger(AbstractExcelParser.class);

    @Override
    public List<T> parse(IParseParam parseParam){

        IExcelParaseHandler<T> handler = this.createHandler(parseParam.getExcelInputStream());

        try {
            return handler.process(parseParam);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


   protected abstract IExcelParaseHandler<T> createHandler(InputStream excelInputStream);



}

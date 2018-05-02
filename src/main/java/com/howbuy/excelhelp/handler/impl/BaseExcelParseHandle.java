package com.howbuy.excelhelp.handler.impl;

import com.howbuy.excelhelp.IParseParam;
import com.howbuy.excelhelp.handler.IExcelParseHandler;
import com.howbuy.excelhelp.meta.ExcelField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author yang.zhou
 * @date 2018/4/28
 */
abstract class BaseExcelParseHandle<T> implements IExcelParseHandler<T> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    <T> Optional<T> parseRowToTarget(IParseParam parseParam, List<String> rowData) {
        if (isRowDataEmpty(rowData)) {
            return Optional.empty();
        }

        try {
            T t = doParseRowToTarget(rowData, parseParam.getTargetClass());
            return Optional.of(t);
        } catch (Exception e) {
            logger.error("", e);
            return Optional.empty();
        }

    }

    private <T> T doParseRowToTarget(List<String> rowData, Class targetClass) throws IllegalAccessException, InstantiationException {
        T object = (T) targetClass.newInstance();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(ExcelField.class)) {

                ExcelField excelField = field.getAnnotation(ExcelField.class);
                int index = excelField.index();
                ExcelField.ExcelFieldType type = excelField.type();
                field.setAccessible(true);
                String setValue = rowData.get(index);
                String toSet = type.buildSetString(setValue);
                field.set(object, toSet);
            }

        }
        return object;
    }


    void validHeader(IParseParam parseParam, List<String> rowData) {

        int index = 0;

        if (rowData.size() != parseParam.getHeader().size()) {
            throw new IllegalArgumentException("Excel Header 检查失败.");
        }

        for (String head : parseParam.getHeader()) {
            if (!Objects.equals(rowData.get(index++), head.trim())) {
                throw new IllegalArgumentException("Excel Header 检查失败.");
            }
        }


    }

    boolean isRowDataEmpty(List<String> rowData) {
        if (rowData == null) {
            return true;
        }

        for (String str : rowData) {
            if (str != null && !Objects.equals("", str.trim())) {
                return false;
            }
        }

        return true;
    }


    protected void handleEndOfRow(IParseParam parseParam, List<String> rowData, List<T> result) {


    }

}
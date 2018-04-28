package com.howbuy.excelhelp.meta;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ExcelField {

    int index();

    ExcelFieldType type() default ExcelFieldType.Str;

    enum ExcelFieldType{

        Str{
            @Override
            public String buildSetString(String in) {
                return in;
            }
        };

        public abstract String buildSetString(String in);
    }
}

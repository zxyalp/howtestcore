package com.howbuy.excelhelp.meta;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface ExcelField {

    int index();

    boolean isRead() default true;

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

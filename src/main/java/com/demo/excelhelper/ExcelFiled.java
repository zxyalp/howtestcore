package com.demo.excelhelper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface ExcelFiled {
    Logger logger = LoggerFactory.getLogger(ExcelFiled.class);

    int index();

    boolean isRead() default true;

}

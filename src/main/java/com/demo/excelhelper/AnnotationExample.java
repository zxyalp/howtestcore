package com.demo.excelhelper;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yang.zhou
 * @date 2018/4/26
 */
public class AnnotationExample {

    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "hit page", date = "Nov 17 2017", revision = 1, comments = "main toString")
    public String toString() {
        return "Overriden toString method.";
    }

    @Deprecated
    @MethodInfo(comments = "old method", date = "Nov 12 2017")
    public static void oldMethod(){
        System.out.println("old method, don't use id");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MethodInfo(author = "alpha go", comments = "main method", date = "Nov 17 2017", revision = 10)
    public static void genericsTest() throws FileNotFoundException{
        List s = new ArrayList<>();
        s.add("sss");
        oldMethod();
    }
}

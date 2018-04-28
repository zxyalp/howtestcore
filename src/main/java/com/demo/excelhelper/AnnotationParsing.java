package com.demo.excelhelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author yang.zhou
 * @date 2018/4/26
 */
public class AnnotationParsing {

    public static void main(String[] args) {
        try {

            for (Method method: AnnotationParsing.class.getClassLoader().loadClass(("com.demo.excelhelper.AnnotationExample")).getMethods()){
                if (method.isAnnotationPresent(MethodInfo.class)){
                    try {
                        for (Annotation annotation:method.getDeclaredAnnotations()){
                            System.out.println("Annotation in method: '"+method+"'; "+annotation);
                        }

                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                        if (methodInfo.revision() == 1){
                            System.out.println("method revison no 1 = "+method);
                        }
                    }catch (Throwable throwable){
                        throwable.printStackTrace();
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

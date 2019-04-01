package com.alex.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented //文档生成时，该注解将被包含在javadoc中，可去掉
@Target(ElementType.METHOD)//目标是方法
@Retention(RetentionPolicy.RUNTIME) //注解会在class中存在，运行时可通过反射获取
@Inherited
public @interface History {

    /**
     * 参数
     * @return
     */
    String[] param() default {};

    /**
     * 检查是否已登录（注解的参数）
     *
     * @return true-检查；默认不检查为false
     */
    boolean check() default false;
}

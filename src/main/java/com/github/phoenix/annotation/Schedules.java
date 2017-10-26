/*
 * @Project Name: JDK8Example
 * @File Name: Schedules.java
 * @Package Name: com.github.phoenix.annotation
 * @Date: 2017年10月26日下午5:55:33
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  重复注解
 * @author zengzw-1220
 * @date 2017年10月26日下午5:55:33
 * @see
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Schedules {
	Schedule[] value();
}

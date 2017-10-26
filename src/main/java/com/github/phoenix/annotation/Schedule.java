/*
 * @Project Name: JDK8Example
 * @File Name: Schedule.java
 * @Package Name: com.github.phoenix.annotation
 * @Date: 2017年10月26日下午5:56:14
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.annotation;

import java.lang.annotation.Repeatable;

/**
 * 重复注解
 * @author zengzw-1220
 * @date 2017年10月26日下午5:56:14
 * @see
 */
@Repeatable(Schedules.class)
public @interface Schedule {
	int hour() default 0;
}

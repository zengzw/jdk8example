/*
 * @Project Name: JDK8Example
 * @File Name: TraditionalAnnoSchedule.java
 * @Package Name: com.github.phoenix.annotation
 * @Date: 2017年10月26日下午5:49:57
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.Authenticator.RequestorType;

/**
 * TODO
 * @author zengzw-1220
 * @date 2017年10月26日下午5:49:57
 * @see
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TraditionalAnnoSchedule {
	 int[] hour() default {0};
}

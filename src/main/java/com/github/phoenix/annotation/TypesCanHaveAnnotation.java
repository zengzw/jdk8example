/*
 * @Project Name: JDK8Example
 * @File Name: TypesCanHaveAnnotation.java
 * @Package Name: com.github.phoenix.annotation
 * @Date: 2017年10月26日下午4:05:43
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
 * 类型注解
 * @author zengzw-1220
 * @date 2017年10月26日下午4:05:43
 * @see
 */

public class TypesCanHaveAnnotation {


	public static void main(String[] args) {

		String a = "successed";

		// can be used for language processing, converters, etc, during static code analysis.
		@Status
		String b = "failed";

		System.out.println((@Status String) a);
		System.out.println(b);
	}

	@Target({ ElementType.TYPE_USE })
	@Retention(RetentionPolicy.SOURCE)
	public @interface Status {
	}
}

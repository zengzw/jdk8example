/*
 * @Project Name: JDK8Example
 * @File Name: AnnotationsCanBeRepeated.java
 * @Package Name: com.github.phoenix.annotation
 * @Date: 2017年10月26日下午4:02:51
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
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * TODO
 * @author zengzw-1220
 * @date 2017年10月26日下午4:02:51
 * @see
 */
public class AnnotationsCanBeRepeated {

	public static String paramName;

	@Release(Type.DEVELOPMENT)
	@Release(Type.QUALITY)
	public static void main(String[] bb) {

		Arrays.asList(new AnnotationsCanBeRepeated().getClass().getDeclaredMethods()).stream()
		.filter(method -> "main".equals(method.getName()))
		.findFirst()
		.ifPresent(method -> System.out.println("annotations: " + method.getAnnotations()[0]));

		System.out.println("Params:");
		// parameter name
		Arrays.asList(new AnnotationsCanBeRepeated().getClass().getDeclaredMethods()).stream()
		.filter(m -> "example".equals(m.getName()))
		.flatMap(m -> Arrays.asList(m.getParameters()).stream())
		.map(Parameter::getName).forEach(System.out::println);

		System.out.println("All methods:");
		Arrays.asList(new AnnotationsCanBeRepeated().getClass().getDeclaredMethods()).stream()
		.forEach(m -> System.out.println(m.getName()));
	}

	public static void example(String a, String b) {

	}

	enum Type {
		PRODUCTION,
		DEVELOPMENT,
		QUALITY
	}

	@Repeatable(Cycle.class)
	@interface Release {
		Type value();
	}

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	@interface Cycle {
		Release[] value();
	}
}

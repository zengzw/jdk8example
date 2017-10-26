/*
 * @Project Name: JDK8Example
 * @File Name: ThreadTest.java
 * @Package Name: com.github.phoenix.lambda
 * @Date: 2017年10月25日上午11:03:48
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * TODO
 * @author zengzw-1220
 * @date 2017年10月25日上午11:03:48
 * @see
 */
public class ThreadTest {


	/**
	 *  线程语法测试
	 * 
	 * @date 2017年10月25日下午4:22:28
	 * @author zengzw-1220
	 * @since 1.0.0
	 */
	public static void testThread(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("---thread old---");	

			}
		}).start();



		//JDK8,V2
		new Thread(()->System.out.println("jdk8")).start();;


		//JDK8,V1
		new Thread(() -> {
			System.out.println("runnable......");
		}).start();;
	}


	/**
	 * 
	 * 测试集合
	 * 
	 * @date 2017年10月25日下午4:24:18
	 * @author zengzw-1220
	 * @since 1.0.0
	 */
	public static void testList(){
		//遍历List
		List<String> features = Arrays.asList("Lambdas", "Default Method", 
				"Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
		//JDK8
		features.forEach(System.out::println);

		System.out.println("------------------");
		features.forEach((x)->System.out.println(x));;

		System.out.println("------------------");
		features.forEach(x -> System.out.println(x));

		System.out.println("------------------");
		features.forEach((String x) -> System.out.println(x));

		System.out.println("------------------");
		features.forEach((x)->{
			x = x + "-kk";
			System.out.println(x);
		});

		System.out.println("------------------");
		features.forEach((x)->{
			String newValue = x + "-new";
			System.out.println(newValue);
		});


		System.out.println("------------------>+");
		features.forEach(x -> {
			Function<String, String> i2s = String::valueOf;
			System.out.println(i2s.apply(x));
		});

		Function<String, Integer> s2i = Integer::new;
		System.out.println(s2i.apply("222"));
	}


	public static void main(String[] args) {

		testThread();

		//testList();


		Consumer<Object> sysout = System.out::println;
		sysout.accept("hello world");
	}
}

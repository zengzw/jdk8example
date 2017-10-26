/*
 * @Project Name: JDK8Example
 * @File Name: TestFcuntion.java
 * @Package Name: com.github.phoenix.funciton
 * @Date: 2017年10月26日下午3:59:39
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.funciton;

/**
 * TODO
 * @author zengzw-1220
 * @date 2017年10月26日下午3:59:39
 * @see
 */
public class TestFcuntion {
	
	public static void main(String[] args) {
		//对方法的实现
		IFunction function = (t) -> {System.out.println("test"+t);};
		function.test(",funciton");
	}
}

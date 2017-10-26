/*
 * @Project Name: JDK8Example
 * @File Name: LambdaExpressionsSyntaxSummary.java
 * @Package Name: com.github.phoenix.lambda
 * @Date: 2017年10月17日上午10:04:36
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.lambda;

import java.util.function.Predicate;

/**
 * 
 * @author zengzw-1220
 * @date 2017年10月17日上午10:04:36
 * @see
 */
public class LambdaExpressionsSyntaxSummary {
	
	public static void main(String[] args) {

			Predicate<Integer> isOld = n -> n % 2 != 0 ;
	}
}

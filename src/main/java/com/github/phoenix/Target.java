/*
 * @Project Name: JDK8Example
 * @File Name: Target.java
 * @Package Name: com.github.phoenix
 * @Date: 2017年10月26日下午5:51:40
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix;

import java.util.Arrays;
import java.util.stream.Stream;

import com.github.phoenix.annotation.Schedule;

/**
 * TODO
 * @author zengzw-1220
 * @date 2017年10月26日下午5:51:40
 * @see
 */
//@TraditionalAnnoSchedule(hour={1,2,3})
@Schedule(hour=1)
@Schedule(hour=2)
public class Target {
	
	public static void main(String[] args) {
/*
		TraditionalAnnoSchedule[]  annoSchedules = 	Target.class.getAnnotationsByType(TraditionalAnnoSchedule.class);
		Stream.of(annoSchedules).forEach(s ->{ System.out.println(Arrays.toString(s.hour()));});	
	*/
		
		Schedule[]  annoSchedules = Target.class.getAnnotationsByType(Schedule.class);
		Stream.of(annoSchedules).forEach(s ->{ System.out.println(s.hour());});	
		
	}
}

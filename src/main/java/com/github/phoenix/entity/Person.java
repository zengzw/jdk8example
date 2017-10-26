/*
 * @Project Name: JDK8Example
 * @File Name: Person.java
 * @Package Name: com.github.phoenix.entity
 * @Date: 2017年10月26日上午10:05:04
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.entity;

/**
 * TODO
 * @author zengzw-1220
 * @date 2017年10月26日上午10:05:04
 * @see
 */
public class Person {

	private String firstName, lastName, job, gender;  
	private int salary, age;  

	public Person(String firstName, String lastName, String job,  
			String gender, int age, int salary)       {  
		this.firstName = firstName;  
		this.lastName = lastName;  
		this.gender = gender;  
		this.age = age;  
		this.job = job;  
		this.salary = salary;  
	}


	public String getFirstName() {

		return firstName;
	}


	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}


	public String getLastName() {

		return lastName;
	}


	public void setLastName(String lastName) {

		this.lastName = lastName;
	}


	public String getJob() {

		return job;
	}


	public void setJob(String job) {

		this.job = job;
	}


	public String getGender() {

		return gender;
	}


	public void setGender(String gender) {

		this.gender = gender;
	}


	public int getSalary() {

		return salary;
	}


	public void setSalary(int salary) {

		this.salary = salary;
	}


	public int getAge() {

		return age;
	}


	public void setAge(int age) {

		this.age = age;
	}  
}

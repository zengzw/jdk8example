/*
 * @Project Name: JDK8Example
 * @File Name: TestStream.java
 * @Package Name: com.github.phoenix.stream
 * @Date: 2017年10月26日上午10:05:51
 * @Creator: zengzw-1220
 * @line------------------------------
 * @修改人: 
 * @修改时间: 
 * @修改内容: 
 */

package com.github.phoenix.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.phoenix.entity.Person;

/**
 * TODO
 * @author zengzw-1220
 * @date 2017年10月26日上午10:05:51
 * @see
 */
public class TestStream {
	static List<Person> javaProgrammers = new ArrayList<Person>() {  
		{  
			add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));  
			add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));  
			add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));  
			add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));  
			add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));  
			add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));  
			add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));  
			add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));  
			add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));  
			add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));  
		}  
	};  

	static List<Person> phpProgrammers = new ArrayList<Person>() {  
		{  
			add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));  
			add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));  
			add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));  
			add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));  
			add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));  
			add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));  
			add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));  
			add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));  
			add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));  
			add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));  
		}  
	};


	public static void main(String[] args) {
	/*	javaProgrammers.forEach(p -> {
			System.out.println(p.getAge() + " " + p.getFirstName());
		});

		System.out.println("--------foreach-------------------");
		
		Consumer<Person> consumer  = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
		javaProgrammers.forEach(consumer);
		System.out.println("--------foreach-------------------");
		
		
		Predicate<Person> namePredicate = p -> (p.getFirstName().startsWith("S"));
		javaProgrammers.stream()
		.filter((p) -> (p.getSalary() > 1400)) //过滤大于1400
		.filter(namePredicate) //过滤名字已S开头
//		.limit(1) //过滤条数
		.forEach(p -> System.out.println(p.getFirstName() +"_"+p.getLastName()));;
		System.out.println("--------stream filter-------------------");
		*/
		
		
		
		//排序
	/*	List<Person> sortedJavaProgrammers = javaProgrammers.stream()
				.sorted((p,p2) -> (p.getFirstName().compareTo(p2.getFirstName()))) //根据名称排序
				.sorted((p,p2)-> (p2.getSalary() - p.getSalary())) // 根据工资排序
//		.limit(5)
		.collect(Collectors.toList());
		
		sortedJavaProgrammers.forEach(s -> System.out.println(s.getFirstName() +" - " + s.getSalary()));
		*/
		
		
		
		//获取最对工资
		Person person = javaProgrammers.stream()
//				.min((p,p1) -> (p.getSalary()-p1.getSalary())).get(); //获取最低
		.max((p,p1) -> (p.getSalary()-p1.getSalary())).get();  //获取最高
		
		System.out.println(person.getFirstName() + "- " + person.getSalary());
		
		
		//转成string
		String phpDevelopers  = javaProgrammers.stream()
//				.map(p->p.getFirstName())
				.map(Person::getFirstName)
		.collect(Collectors.joining(","));
		System.out.println(phpDevelopers);
		
		
		//转成set
		Set<String> set = javaProgrammers.stream()
		.map(Person::getFirstName)
		.collect(Collectors.toSet());
		
		System.out.println(set);
		
		
		//转成map
		Map<String, String> map = javaProgrammers.stream()
		.collect(Collectors.toMap(Person::getFirstName, Person::getJob));
		System.out.println(map);
		
		
		//转成treet set
		TreeSet<String> treeSet = javaProgrammers.stream()
		.map(Person::getFirstName)
		.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);
		
		
		//ConcurrentMap
		ConcurrentMap<String,String> concurrentHashMap = javaProgrammers.stream()
		.collect(Collectors.toConcurrentMap(Person::getFirstName,Person::getLastName));
		System.out.println(concurrentHashMap);
		
		
		/**
		 * Streams 还可以是并行的(parallel)。  .它通过默认的ForkJoinPool,可能提高你的多线程任务的速度.
		 */
		int totalSalary = javaProgrammers.parallelStream()
				.mapToInt(Person::getSalary)
				.sum();
		
		System.out.println(totalSalary);
		
		//由于多线程，输出的顺序并不是存入的顺序，随机。
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.parallelStream()
//		       .forEach(System.out::println); 
		.forEachOrdered(System.out::println); //安装集合的顺序输出
		
		
		
		List<Integer> listNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		IntSummaryStatistics summaryStatistics = listNumbers.stream().mapToInt(x -> x)
		.summaryStatistics();
		System.out.println("平均数:"+summaryStatistics.getAverage());
		System.out.println("总数:"+summaryStatistics.getCount());
		System.out.println("最大:"+summaryStatistics.getMax());
		System.out.println("最小:"+summaryStatistics.getMin());
		System.out.println("总和:"+summaryStatistics.getSum());
		
		
		
		/**
		 * map reduce
		 * Map阶段：对集合中的元素进行操作
		   Reduce阶段：将上一步得到的结果进行合并得到最终的结果
		 */
		
		 final List<Integer> nums = Arrays.asList(1, 2, 3, 4);
	       Integer countResult = nums.stream()
	                .map(number -> number * 2)
	               .reduce((count,numb) -> count + numb)
	               .get();
	       System.out.println(countResult);

		
	}
}

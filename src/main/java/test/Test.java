package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("B", 10000));
		employees.add(new Employee("A", 10000));
		employees.add(new Employee("C", 15000));
		employees.add(new Employee("E", 12000));
		employees.add(new Employee("D", 12000));
		
		Map<Integer, Set<String>> map = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toSet())));
		 
		System.err.println(map);
	}
}

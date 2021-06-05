package com.company;

import com.company.dao.inter.EmployeeDaoInter;
import com.company.dao.inter.EmployeeRepository;
import com.company.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class EmployeeDbAppSpringApplication {



	public static void main(String[] args) {
		SpringApplication.run(EmployeeDbAppSpringApplication.class, args);
	}

	/*@Autowired
	private EmployeeDaoInter employeeDaoInter;*/

	@Autowired
	private EmployeeRepository employeeRepository;

	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {

				//Employee employee = employeeDaoInter.getById(1);
				//System.out.println(employee);

				//Employee emp = employeeRepository.findById(1);
				//Optional<Employee> emp = employeeRepository.findById(1);
				//System.out.println(emp);


			}
		};
		return clr;
	}
}

package Employeeportal.arvindpvtltd.service;

import java.util.List;

import Employeeportal.arvindpvtltd.model.Employee;

public interface IEmployeeService {

	Employee addEmp(Employee employee);

	List<Employee> getAllemp();

	

	

	boolean deleteByEmpid(long empid);

	Employee updateByEmpid(Employee employee);

	Employee findByEmpId(long empid);

}

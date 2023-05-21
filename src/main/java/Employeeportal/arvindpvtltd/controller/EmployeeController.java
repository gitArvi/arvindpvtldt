package Employeeportal.arvindpvtltd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Employeeportal.arvindpvtltd.model.Employee;
import Employeeportal.arvindpvtltd.service.IEmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {
      
	@Autowired
	private IEmployeeService   iEmployeeService;

	
	@PostMapping("/employees")

	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{     System.out.println("contoller addemployee");
		Employee emp=iEmployeeService.addEmp(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{    System.out.println("contoller getemployee"); 
		List<Employee> emp=   iEmployeeService.getAllemp();
		return new ResponseEntity<List<Employee>>(emp,HttpStatus.OK);
	}
	@GetMapping("/employees/{empid}")
	public  ResponseEntity<Employee>  getEmployeeById(@PathVariable long empid)
	{      System.out.println(" getemployee by id");
		Employee emp=iEmployeeService.findByEmpId(empid);
		return new   ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateemployees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{     System.out.println("contoller updateemployee");
		Employee emp=iEmployeeService.updateByEmpid(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteemployees/{empid}")
	public boolean deleteEmployee(@PathVariable long empid)
	{
		 System.out.println("contoller deleteemployee");
		return iEmployeeService.deleteByEmpid(empid);
	}
}

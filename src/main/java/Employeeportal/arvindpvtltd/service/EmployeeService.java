package Employeeportal.arvindpvtltd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Employeeportal.arvindpvtltd.Exception.ProductNotFoundException;
import Employeeportal.arvindpvtltd.model.Employee;
import Employeeportal.arvindpvtltd.repository.EmployeeRespository;

@Service
public class EmployeeService implements IEmployeeService{
      @Autowired 
	private EmployeeRespository  employeeRespository;
	
	@Override
	public Employee addEmp(Employee employee) {
		Employee emp=employeeRespository.findByEmpid(employee.getEmpid());
//		if(!employeeRespository.existsByEmailid(employee.getEmailid()))
//		{
//			try {
//				throw new ProductNotFoundException();
//			}
//			catch(ProductNotFoundException e)
//			{
//				System.out.println("the email id of this employee " +employee.getEmailid()+ "not found" );
//			}
//		}
		if(emp==null)
		{    
			Employee emp1=employeeRespository.save(employee);
			return emp1;
		}
		return emp;
	}

	@Override
	public List<Employee> getAllemp() {
		// TODO Auto-generated method stub
		List<Employee> emp=employeeRespository.findAll();
		return emp;
	}
	@Override
	public Employee findByEmpId(long empid) {
		
		
		Employee emp=employeeRespository.findByEmpid(empid);
		if(emp!=null)
		{   System.out.println("Get by id");
			return emp;
		}
		
		return null;
		}

	

	

//	@Override
//	public Employee updateByEmpid(Employee employee) {
//		// TODO Auto-generated method stub
//		Employee emp=employeeRespository.findByEmpid(employee.getEmpid());
//		if(emp!=null)
//		{
//			Employee emp1=employeeRespository.save(employee);
//			return emp1;
//		}
//		return employee;
//	
//	}
	public Employee updateByEmpid(Employee updatedEmployee) {
	    Employee existingEmployee = employeeRespository.findById(updatedEmployee.getEmpid()).orElse(null);
	    if (existingEmployee != null) {
	        existingEmployee.setFirstname(updatedEmployee.getFirstname());
	        existingEmployee.setLastname(updatedEmployee.getLastname());
	        existingEmployee.setEmailid(updatedEmployee.getEmailid());
	        // Set other properties as needed

	        return employeeRespository.save(existingEmployee);
	    }
	    return null; // or throw an exception if the employee doesn't exist
	}
//	@Override
//	public boolean deleteByEmpid(long empid) {
//		// TODO Auto-generated method stub
//		
//		if(employeeRespository.existsByEmpid(empid))
//		{
//			employeeRespository.deleteByEmpid(empid);
//			return true;
//		}
//		return false;
//	}
	@Override
	public boolean deleteByEmpid(long empid) {
	    int deletedCount = employeeRespository.deleteByEmpid(empid);
	    return deletedCount > 0;
	}

}

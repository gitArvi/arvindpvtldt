package Employeeportal.arvindpvtltd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Employeeportal.arvindpvtltd.model.Employee;

@Repository
@Transactional
public interface EmployeeRespository extends JpaRepository<Employee, Long> {
//
	Employee findByEmpid(long empid);





	boolean existsByEmpid(long empid);




	 @Modifying
	    @Query("DELETE FROM Employee e WHERE e.empid = :empid")
	    int deleteByEmpid(long empid);

	

	

}

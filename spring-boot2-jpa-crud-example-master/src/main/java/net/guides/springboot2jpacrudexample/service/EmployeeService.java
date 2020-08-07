package net.guides.springboot2jpacrudexample.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import net.guides.springboot2.springboot2jpacrudexample.dto.EmployeeDTO;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;

public interface EmployeeService {

	public List<EmployeeDTO> getAllEmployees(Pageable paging); 
	
	public EmployeeDTO getEmployeeById(Long employeeId) throws ResourceNotFoundException;
	
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO);	
	
	public void deleteEmployee(Long employeeId);
	
}

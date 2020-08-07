package net.guides.springboot2jpacrudexample.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.guides.springboot2.springboot2jpacrudexample.dto.EmployeeDTO;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService	{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
		
	//@HystrixCommand(fallbackMethod="getDefaultEvents")
	public List<EmployeeDTO> getAllEmployees(Pageable paging) {
		
		List<Employee> listEmployees =  employeeRepository.findAll(paging).stream().collect(Collectors.toList());
		
		//employeeRepository.find
		List<EmployeeDTO> listEmployeesDTO = listEmployees
		  .stream()
		  .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
		  .collect(Collectors.toList());		
		
		return listEmployeesDTO;		
	}
	
	//@HystrixCommand(fallbackMethod="getDefaultEvents")
	public EmployeeDTO getEmployeeById(Long employeeId) throws ResourceNotFoundException{	
	
		Employee employee = employeeRepository.findById(employeeId)				
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
				return employeeDTO;
	}
	
	@Transactional
	//@HystrixCommand(fallbackMethod="getDefaultEvents")
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employee =	employeeRepository.save(modelMapper.map(employeeDTO, Employee.class));		
		return modelMapper.map(employee, EmployeeDTO.class);
	}	

	//@HystrixCommand(fallbackMethod="getDefaultEvents")
	public void deleteEmployee(Long employeeId){
		employeeRepository.deleteById(employeeId);
	}
	
	@SuppressWarnings("unused")
	private String getDefaultEvents(){
		return "This is fallback method";
	}
}

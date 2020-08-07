package net.guides.springboot2.springboot2jpacrudexample;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(AppConfig.class)
//@WebAppConfiguration


@Configuration

@EnableWebMvc
@EnableTransactionManagement
@PropertySource(value = {"classpath:src/main/resources/application.properties"})
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	 @Autowired
	  private TestEntityManager entityManager;
	

    @Autowired
    private EmployeeRepository employeeRespository;

//    @Test
//    public void shouldSaveAndFetchPerson() throws Exception {
//      
//    	Employee employee = new Employee();
//    	
//    	employee.setId(1l);;
//    	employee.setEmailId("pepe@mail.com");
//    	employee.setLastName("RORO");
//    	employee.setFirstName("roberto");
//
//    	entityManager.persist(employee);
//
//        Optional<Employee> maybePeter = employeeRespository.findById(1l);
//        assertTrue(true);
//    }
    
    
    @Test
    public void should_find_all_tutorials() {
      Employee tut1 = new Employee("Tut#1", "Desc#1", "true");
      entityManager.persist(tut1);

      Employee tut2 = new Employee("Tut#1", "Desc#1", "true");
      entityManager.persist(tut2);
      
      Employee tut3 = new Employee("Tut#1", "Desc#1", "true");
      entityManager.persist(tut3);
      
      Iterable<Employee> tutorials = employeeRespository.findAll();

      assertThat(tutorials).hasSize(3).contains(tut1, tut2, tut3);
    }
   
}
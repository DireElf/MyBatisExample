package elf.dire;

import elf.dire.mapper.EmployeeMapper;
import elf.dire.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = "classpath:create_test_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:remove_test_data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void findByIdTest() {
        Employee employee = employeeMapper.findById(1L);
        assertNotNull(employee, "Employee is null");
        assertEquals("John", employee.getName());
        assertEquals("Smith", employee.getSurname());
        assertEquals("john@yahoo.com", employee.getEmail());
        assertEquals(33, employee.getAge());
    }

    @Test
    void findAllTest() {
        List<Employee> employeeList = employeeMapper.findAll();
        assertEquals(2, employeeList.size());
        System.out.println(employeeList.get(0).getName());
        System.out.println(employeeList.get(1).getName());
    }

    @Test
    void insertTest() {
        Employee employee = new Employee();
        employee.setName("TestName");
        employee.setSurname("TestSurname");
        employee.setEmail("test@test.com");
        employee.setAge(55);
        employeeMapper.insert(employee);
        List<Employee> employeeList = employeeMapper.findAll();
        assertEquals(3, employeeList.size());
    }

    @Test
    void deleteTest() {
        List<Employee> employeeListBefore = employeeMapper.findAll();
        assertEquals(2, employeeListBefore.size());
        employeeMapper.delete(1L);
        List<Employee> employeeListAfter = employeeMapper.findAll();
        assertEquals(1, employeeListAfter.size());
    }

    @Test
    void updateTest() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("TestName");
        employee.setSurname("TestSurname");
        employee.setEmail("test@test.com");
        employee.setAge(55);
        Employee empBefore = employeeMapper.findById(1L);
        employeeMapper.update(employee);
        Employee empAfter = employeeMapper.findById(1L);
        assertNotEquals(empBefore, empAfter);
    }
}

package elf.dire.mapper;

import elf.dire.model.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Аннотации закомментированы, поскольку используется xml-маппер
 */
public interface EmployeeMapper {
//    @Select("SELECT * FROM employees WHERE id = #{id}")
    Employee findById(Long id);

//    @Select("SELECT * FROM employees")
    List<Employee> findAll();

//    @Insert("INSERT INTO employees (name, surname, email, age) VALUES (#{name}, #{surname}, #{email}, #{age})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Employee employee);
}

package jdbc.hrproject.repository;

import jdbc.hrproject.entity.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpReps extends CrudRepository<Employee, String> {
    public List<Employee> findByName(String name) ;
    public List<Employee> findByNameOrSalary(String name, double salary);

    public List<Employee> findByNameStartingWithOrSalary(String name, double salary);

    @Query(value = "SELECT * FROM employee WHERE name like ':name%' and id > :id")
    public Employee findByNameAndSalary(@Param("name") String name, @Param("id") int id);
}

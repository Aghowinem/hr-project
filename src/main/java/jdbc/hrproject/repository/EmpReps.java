package jdbc.hrproject.repository;

import jdbc.hrproject.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpReps extends CrudRepository<Employee, String> {
}

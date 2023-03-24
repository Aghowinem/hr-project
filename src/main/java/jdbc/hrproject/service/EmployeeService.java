package jdbc.hrproject.service;

import jdbc.hrproject.entity.Employee;
import jdbc.hrproject.repository.EmpReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmpReps empReps;

    public List<Employee> findByName(String name) {
        return empReps.findByName(name);
    }

    public List<Employee> findByNameOrSalary(String name, double salary) {
        return empReps.findByNameOrSalary(name, salary);
    }

    public List<Employee> findByNameStartingWithOrSalary(String name, double salary) {
        return findByNameStartingWithOrSalary(name, salary);
    }

    public Employee findByNameAndId(String name, int id) {
        return empReps.findByNameAndId(name, id);
    }

    public int updateSalary(double salary, int id){
        return empReps.updateSalary(salary,id);
    }

    //# Controller Methods #//

    public int count() {
        return (int) empReps.count();
    }


    public Optional<Employee> findById(int id,  String acceptLanguage) {
        return empReps.findById(String.valueOf(id));
    }

    public List<Employee> findAll(){
        return (List<Employee>) empReps.findAll();
    }

    public void delete(@PathVariable int id){
        empReps.deleteById(String.valueOf(id));
        System.out.println(id+"has been deleted");
    }
    //# Post Methods #//
    public Employee insert(Employee employee){
        return empReps.save(employee);
    }

    public Employee update(Employee employee){
        return empReps.save(employee);
    }
}

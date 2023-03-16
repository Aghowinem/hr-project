package jdbc.hrproject.controller;

import jdbc.hrproject.entity.Employee;
import jdbc.hrproject.repository.EmpReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {

    @Autowired
    private EmpReps empReps;

    @GetMapping("/count")
    public int countEmp(){
        return (int) empReps.count();
    }

    @GetMapping("/findall")
    public List<Employee> findAll(){
        return (List<Employee>) empReps.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findbyid(@PathVariable String id){
        return empReps.findById(id);
    }

}

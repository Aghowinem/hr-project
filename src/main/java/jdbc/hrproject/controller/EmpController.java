package jdbc.hrproject.controller;

import jdbc.hrproject.entity.Employee;
import jdbc.hrproject.repository.EmpReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmpController {

    @Autowired
    private EmpReps empReps;

    @GetMapping("/count")
    public int countEmp(){
        return (int) empReps.count();
    }

    @GetMapping("")
    public List<Employee> findAll(){
        return (List<Employee>) empReps.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Optional<Employee> findById(@PathVariable int id){
        return empReps.findById(String.valueOf(id));
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        empReps.deleteById(String.valueOf(id));
        System.out.println(id+"has been deleted");
    }
//    @GetMapping("/insert")
//    public Employee addEmployee(){
//        return empReps.save(new Employee(null,"Waeel","CS","SWE",13200.0,"M"));
//    }
    @GetMapping("/update/{id}")
    public Employee update(@PathVariable int id){
        return empReps.save(new Employee(id,"Waeel","CS","SWE",13200.0,"M"));
    }

    @GetMapping("/findbyname/{name}")
        public List<Employee> FindByName(@PathVariable String name){
        return empReps.findByName(name);
    }

    @GetMapping("/nameorsalary/{name}/{salary}")
    public List<Employee> findByNameAndSalary(@PathVariable String name, @PathVariable double salary){
        return empReps.findByNameOrSalary(name,salary);
    }
    @GetMapping("/namestartwith/{name}/{salary}")
    public List<Employee> findByNameStartingWithOrSalary(@PathVariable String name, @PathVariable double salary){
        return empReps.findByNameStartingWithOrSalary(name,salary);
    }

    @GetMapping("/findbynameandsalary/{name}/{id}")
    public Employee findByNameAndSalary(@PathVariable int id,@PathVariable String name){
        return empReps.findByNameAndSalary(name,id);
    }

}

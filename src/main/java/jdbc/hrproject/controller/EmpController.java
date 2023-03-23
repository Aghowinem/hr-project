package jdbc.hrproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdbc.hrproject.entity.Employee;
import jdbc.hrproject.repository.EmpReps;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/findall")
    public List<Employee> findAll(){
        return (List<Employee>) empReps.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return ResponseEntity.accepted().body(empReps.findById(String.valueOf(id)));
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

    @GetMapping("/filter1/{name}/{salary}")
    public List<Employee> findByNameAndSalary(@PathVariable String name, @PathVariable double salary){
        return empReps.findByNameOrSalary(name,salary);
    }
    @GetMapping("/filter")
    public List<Employee> findByNameStartingWithOrSalary(@RequestParam String name, @RequestParam double salary){
        return empReps.findByNameStartingWithOrSalary(name,salary);
    }

    @PostMapping("")
    public Employee addEmp(@RequestBody Employee employee){
            return empReps.save(employee);
    }
    @PutMapping("")
    public Employee updateEmp(@RequestBody Employee employee){
        return empReps.save(employee);
    }

    @DeleteMapping("{empid}")
    public void deleteEmp(@PathVariable("empid") String id){
        empReps.deleteById(id);
    }

    public void testJackson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                "    \"id\": 150,\n" +
                "    \"name\": \"waeel\",\n" +
                "    \"major\": null,\n" +
                "    \"title\": null,\n" +
                "    \"salary\": 0.0,\n" +
                "    \"gender\": null\n" +
                "}";
        Employee empObject = mapper.readValue(json,Employee.class);
        json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empObject);
    }
}

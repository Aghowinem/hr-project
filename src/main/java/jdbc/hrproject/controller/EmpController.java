package jdbc.hrproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdbc.hrproject.entity.Employee;
import jdbc.hrproject.repository.EmpReps;
import jdbc.hrproject.service.EmployeeService;
import org.apache.coyote.Response;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmpController {

    Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/count")
    public int countEmp(){
        return (int) employeeService.count();
    }

    @GetMapping("/findall")
    public List<Employee> findAll(){
        return (List<Employee>) employeeService.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Optional<Employee> findById(@PathVariable int id, @RequestHeader("acceptLanguage") String acceptLanguage){
        log.info("Accept Language is" + acceptLanguage);
        return employeeService.findById(id,acceptLanguage);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
        System.out.println(id+"has been deleted");
    }
//    @GetMapping("/insert")
//    public Employee addEmployee(){
//        return empReps.save(new Employee(null,"Waeel","CS","SWE",13200.0,"M"));
//    }
    @GetMapping("/update/{id}")
    public Employee update(@PathVariable int id){
        return employeeService.update(new Employee(id,"Waeel","CS","SWE",13200.0,"M"));
    }

    @GetMapping("/findbyname/{name}")
        public List<Employee> FindByName(@PathVariable String name){
        return employeeService.findByName(name);
    }

    @GetMapping("/filter1/{name}/{salary}")
    public List<Employee> findByNameAndSalary(@PathVariable String name, @PathVariable double salary){
        return employeeService.findByNameOrSalary(name,salary);
    }
    @GetMapping("/filter")
    public List<Employee> findByNameStartingWithOrSalary(@RequestParam String name, @RequestParam double salary){
        return employeeService.findByNameStartingWithOrSalary(name,salary);
    }

    @PostMapping("")
    public Employee addEmp(@RequestBody Employee employee){
            return employeeService.insert(employee);
    }
    @PutMapping("")
    public Employee updateEmp(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
    @PutMapping("/salary")
    public int updateSalary(@RequestParam double salary, @RequestParam int id){
        return employeeService.updateSalary(salary,id);
    }

    @DeleteMapping("{empid}")
    public void deleteEmp(@PathVariable("empid") int id){
        employeeService.delete(id);
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

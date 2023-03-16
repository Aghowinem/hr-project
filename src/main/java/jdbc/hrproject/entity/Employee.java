package jdbc.hrproject.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")

public class Employee {

    @Id
    @Column("id")
    private String id;
    private String name;
    private String major;
    private String title;

    private double salary;

    private String gender;

    public Employee(String id, String name, String major, String title, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.title = title;
        salary = salary;
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(double salary) {
        salary = salary;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getTitle() {
        return title;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }
}

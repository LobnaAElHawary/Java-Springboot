package com.example.spring_boot.student;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Period;

// to map this class to our db
@Entity // for hibernate
@Table // created a table in our db when we ran the code
public class Student {
    // This created a sequence in the student table in our db
    @Id
    @SequenceGenerator(
        name="student_sequence",
        sequenceName = "student_sequence",
        allocationSize=1 //increment the sequence by 1
    )
    @GeneratedValue(
         strategy = GenerationType.SEQUENCE,
         generator = "student_sequence"
    )
    private Long id;
    private String name;

    @Transient // this lets us know that this does not have to be a column in our db (bc we can calculate age based on dob i.e. date of birth)
    private Integer age;
    private LocalDate dob; //date of birth
    private String email;

    public Student()
    {
    }

    public Student(Long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student(String name, LocalDate dob, String email)
    {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    // set getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student {id=" + id + ", name=" + name + ", age=" + age + "}";
    }
}

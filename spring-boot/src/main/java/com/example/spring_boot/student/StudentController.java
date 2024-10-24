package com.example.spring_boot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //makes the class to serve rest endpoints
@RequestMapping(path="api/v1/student") // This is where we would go if we went to localhost:8080/api/v1/student
public class StudentController {

    // Dependancy injection: telling it we should inject the student service
    private final StudentService studentService; // to tell it this needs to be instantiated (i.e. a bean) we added @Component to the student service class
    @Autowired // This is what indicates that this is a dependancy injection. It will instantiate a studentService class for us
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //when there is a get request, it calls this function
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    // @RequestBody means we take the request body and we map it into a student
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    // This will take the studendId in the path and store it into Long id
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) {
        studentService.updateStudent(studentId, name, email);
    }
}

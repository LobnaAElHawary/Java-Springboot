package com.example.spring_boot.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

//@Component // this indicates that this needs to be instantiated (i.e. it is a bean)
@Service // same as @Component, but better readability
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired // to indicate that we are using dependancy injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents()
    {
//        return List.of(
//                new Student(1L,
//                        "Lobna",
//                        25,
//                        LocalDate.of(2000, Month.APRIL, 5),
//                        "lobna@gmail")
//        );
        return studentRepository.findAll(); // this returns a list
    }

    public void addNewStudent(Student student)
    {
        Optional<Student> studentOptional =
                studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("Email is taken");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId)
    {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("Student does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional  // Indicates that We are not using any queries from the repo, instead we will
    // the setters from the entity itself to update the data in the database
    public void updateStudent(Long studentId, String name, String email)
    {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student does not exist"));
        if(name != null)
        {
            student.setName(name);
        }
        if (email != null)
        {
            student.setEmail(email);
        }
    }
}

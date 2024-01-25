package ankush.dev.studentinfo.thirdpartyclient;


import ankush.dev.studentinfo.models.Student;
import ankush.dev.studentinfo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class StudentInfoClient {
    private StudentRepository studentRepository;

    @Autowired
    public StudentInfoClient(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudentById(UUID uuid) {
        Optional<Student> student = studentRepository.findById(uuid);
        return student;
    }

     public void createStudentInfo(Student student){
        studentRepository.save(student);
     }

     public void deleteStudentInfo(UUID uuid){
        studentRepository.deleteById(uuid);
     }
     public Student updateStudentInfo(UUID uuid, Student student){
        Optional<Student> student1 = studentRepository.findById(uuid);

        Student student2 = student1.get();
        student2.setName(student.getName());
        student2.setAge(student.getAge());
        student2.setBatch(student.getBatch());
        student2.setEmail(student.getEmail());

       studentRepository.save(student2);

       return student2;
     }
}

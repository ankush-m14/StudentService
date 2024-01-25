package ankush.dev.studentinfo.services;

import ankush.dev.studentinfo.dto.GenericStudentDto;
import ankush.dev.studentinfo.exceptions.NotFoundException;
import ankush.dev.studentinfo.models.Student;
import ankush.dev.studentinfo.thirdpartyclient.StudentInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentInfoClient studentInfoClient;

    @Autowired
    public StudentServiceImpl(StudentInfoClient studentInfoClient) {
        this.studentInfoClient = studentInfoClient;
    }

    @Override
    public GenericStudentDto getStudentById(String id) throws NotFoundException {
        UUID uuid = UUID.fromString(id);
        Optional<Student> student = studentInfoClient.getStudentById(uuid);
        return student.map(this::convertStudentToGenericStudentDto)
                .orElseThrow(() -> new NotFoundException("The student with " + id + " is not found"));
    }

    @Override
    public Optional<GenericStudentDto> createStudentInfo(GenericStudentDto genericStudentDto) {
        Student student = convertGenericStudentDtoToStudent(genericStudentDto);
        studentInfoClient.createStudentInfo(student);

        return Optional.empty();
    }

    @Override
    public Optional<GenericStudentDto> deleteStudentInfo(String id) {
        UUID uuid = UUID.fromString(id);

        studentInfoClient.deleteStudentInfo(uuid);

        return Optional.empty();
    }

    @Override
    public GenericStudentDto updateStudentInfo(String id, GenericStudentDto genericStudentDto) {

        Student student = convertGenericStudentDtoToStudent(genericStudentDto);

        UUID uuid = UUID.fromString(id);
        Student student1 = studentInfoClient.updateStudentInfo(uuid, student);

        return convertStudentToGenericStudentDto(student1);
    }

    public Student convertGenericStudentDtoToStudent(GenericStudentDto genericStudentDto){
        Student student = new Student();

        student.setName(genericStudentDto.getName());
        student.setAge(genericStudentDto.getAge());
        student.setBatch(genericStudentDto.getBatch());
        student.setEmail(genericStudentDto.getEmail());

        return student;
    }
    public GenericStudentDto convertStudentToGenericStudentDto(Student student){
       GenericStudentDto genericStudentDto = new GenericStudentDto();

        genericStudentDto.setId(student.getUuid().toString());
        genericStudentDto.setName(student.getName());
        genericStudentDto.setAge(student.getAge());
        genericStudentDto.setBatch(student.getBatch());
        genericStudentDto.setEmail(student.getEmail());

        return genericStudentDto;
    }
}

package ankush.dev.studentinfo.controller;

import ankush.dev.studentinfo.dto.GenericStudentDto;
import ankush.dev.studentinfo.exceptions.NotFoundException;
import ankush.dev.studentinfo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public GenericStudentDto getStudentById(@PathVariable("id") String id) throws NotFoundException{
        return studentService.getStudentById(id);
    }
    @PostMapping
    public Optional<GenericStudentDto> createStudentInfo (GenericStudentDto genericStudentDto){
        return studentService.createStudentInfo(genericStudentDto);
    }

    @DeleteMapping("{id}")
    public Optional<GenericStudentDto> deleteStudentInfo(@PathVariable("id") String id){
        return studentService.deleteStudentInfo(id);
    }
    @PutMapping("{id}")
    public GenericStudentDto updateStudentInfo(@PathVariable("id") String id,
                                               @RequestBody GenericStudentDto genericStudentDto){

       return studentService.updateStudentInfo(id, genericStudentDto);
    }
}
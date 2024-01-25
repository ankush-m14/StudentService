package ankush.dev.studentinfo.services;

import ankush.dev.studentinfo.dto.GenericStudentDto;
import ankush.dev.studentinfo.exceptions.NotFoundException;

import java.util.Optional;

public interface StudentService {

    public GenericStudentDto getStudentById(String id) throws NotFoundException;

    public Optional<GenericStudentDto> createStudentInfo(GenericStudentDto genericStudentDto);
    public Optional<GenericStudentDto> deleteStudentInfo(String id);
    public GenericStudentDto updateStudentInfo(String id, GenericStudentDto genericStudentDto);
}

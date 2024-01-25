package ankush.dev.studentinfo.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends BaseModel {
// STUDENT info
    private int age;
    private String name;
    private String email;
    private String batch;
}

package miagefi.tp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="student")
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
    @GeneratedValue (generator = "student_id_sequence")
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="age")
    private Integer age;
    @Column(name="email")
    private String email;

}

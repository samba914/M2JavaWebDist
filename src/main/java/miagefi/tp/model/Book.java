package miagefi.tp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="book")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue (generator = "book_id_sequence")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name="student_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Student student;

}


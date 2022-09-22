package miagefi.tp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentDbRepository extends JpaRepository<Student,Integer> {
    public List<Student> findAll();
    public Optional<Student> findById(Integer Id);
    public Optional<Student> findByEmail(String email);
    public List<Student> findAllByFirstName(String firstName);
    public List<Student> findByAgeGreaterThan(Integer age);
    public Student findByFirstNameAndLastName(String firstName, String lastName);

}

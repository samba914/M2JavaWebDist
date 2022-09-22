package miagefi.tp.repositoty;

import miagefi.tp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentEntityRepository extends JpaRepository<Student,Integer> {
    public List<Student> findAll();
    public Optional<Student> findById(Integer Id);
    public Optional<Student> findByEmail(String email);
    public List<Student> findAllByFirstName(String firstName);
    public List<Student> findByAgeGreaterThan(Integer age);
    public Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);

}

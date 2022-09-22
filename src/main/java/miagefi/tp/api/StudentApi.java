package miagefi.tp.api;


import lombok.AllArgsConstructor;
import miagefi.tp.model.Book;
import miagefi.tp.model.Student;
import miagefi.tp.repositoty.StudentEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class StudentApi {
    private final StudentEntityRepository studentRepo;

    @GetMapping("students")
    public List<Student> getAll(){
        return studentRepo.findAll();
    }

    @GetMapping("students/email/{email}")
    public Student getByEmail(@PathVariable String email){
        Optional<Student> st= studentRepo.findByEmail(email);
        return st.get();
    }

    @GetMapping("students/firstname/{firstname}")
    public List<Student> findAllByFirstName(@PathVariable String firstname){
        return studentRepo.findAllByFirstName(firstname);
    }

    @GetMapping("students/findByAgeGreaterThan/age/{age}")
    public List<Student> findByAgeGreaterThan(@PathVariable Integer age){
        return studentRepo.findByAgeGreaterThan(age);
    }

    @PostMapping("students/savestudent")
    public Student saveStudent(@RequestBody Student st){
        return studentRepo.save(st);
    }

    @PutMapping("students/updateemail")
    public Student updateEmail(@RequestParam int id, @RequestParam String email){
        Optional<Student> st = studentRepo.findById(id);
        st.ifPresent(value-> value.setEmail(email));
        return studentRepo.save(st.orElse(null));
    }

    @PutMapping("students/lastname")
    public Student updateEmail(@RequestParam String email, @RequestParam String lastname){
        Optional<Student> st = studentRepo.findByEmail(email);
        st.ifPresent(value-> value.setLastName(lastname));
        return studentRepo.save(st.orElse(null));
    }

    @PutMapping("students/incrementage")
    public List<Student> updateIncrementage(){
        List<Student> students = studentRepo.findAll();
        students.forEach(st-> st.setAge(st.getAge()+1));
        return studentRepo.saveAll(students);
    }

    @DeleteMapping("students/delete")
    public void deleteStudent(@RequestBody Student st){
        studentRepo.delete(st);
    }









}

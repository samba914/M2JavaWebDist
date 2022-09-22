package miagefi.tp.api;

import lombok.AllArgsConstructor;
import miagefi.tp.model.Book;
import miagefi.tp.model.Student;
import miagefi.tp.repositoty.BookEntityRepository;
import miagefi.tp.repositoty.StudentEntityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor

public class BookApi {
    public final BookEntityRepository bookRepo;
    public final StudentEntityRepository studentRepo;

    @GetMapping("books")
    public List<Book> getAll(){
        return bookRepo.findAll();
    }
    @GetMapping("books/code/{code}")
    public Book getByCode(@PathVariable String code){
        Optional<Book> book = bookRepo.findByCode(code);
        return book.orElse(null);
    }

    @PostMapping("books/add")
    public Book saveBook(@RequestBody Book book){
        return bookRepo.save(book);
    }

   /* @PutMapping("books/updatestudentbooklist")
    public Student updateBookList(@RequestParam String firstname, @RequestParam String lastname, @RequestBody List<Book> listBook){
        Optional<Student> st = studentRepo.findByFirstNameAndLastName(firstname,lastname);
        if(st.isPresent()){
            st.get().setBooks(listBook);
            listBook.forEach(b->b.setStudent(st.get()));
            bookRepo.saveAll(listBook);
        }
        return studentRepo.save(st.orElse(null));

    }*/



}

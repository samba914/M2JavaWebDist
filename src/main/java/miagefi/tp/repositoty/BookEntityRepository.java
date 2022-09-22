package miagefi.tp.repositoty;

import miagefi.tp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookEntityRepository extends JpaRepository<Book,Integer> {
    public List<Book> findAll();
    public Optional<Book> findByCode(String code);
}

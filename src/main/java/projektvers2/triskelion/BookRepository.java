package projektvers2.triskelion;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @NotNull
    Optional<Book> findById(@NotNull Long id);

}

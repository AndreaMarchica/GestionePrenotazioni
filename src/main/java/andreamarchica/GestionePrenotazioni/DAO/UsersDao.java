package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersDao extends JpaRepository<User, Long> {

    List<User> findByCompleteName(String surname);

    List<User> findByNameIn(List<String> names);

    List<User> findByEmail(String email);
}

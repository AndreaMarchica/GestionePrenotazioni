package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.User;
import andreamarchica.GestionePrenotazioni.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsersService {
    @Autowired
    private UsersDao usersDao;

    public void saveUser(User user) {
        usersDao.save(user);
    }
    public User findById(long id) throws NotFoundException {
        return usersDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

    public void findByIdAndDelete(long id) {
        User found = this.findById(id);
        usersDao.delete(found);
        log.info("User con id " + id + " eliminato con successo!");
    }

    public void findByIdAndUpdate(long id, User user) {
        User found = this.findById(id);
        found.setUsername(user.getUsername());
        found.setCompleteName(user.getCompleteName());
        found.setEmail(user.getEmail());
        found.setBookingList(user.getBookingList());
        usersDao.save(found);
        log.info("User con id " + id + " aggiornato con successo!");
    }
}

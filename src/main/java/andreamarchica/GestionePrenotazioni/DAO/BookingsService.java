package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Booking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingsService {
    @Autowired
    private BookingsDao bookingsDao;
    public void saveBooking(Booking booking) {
        bookingsDao.save(booking);
    }
}

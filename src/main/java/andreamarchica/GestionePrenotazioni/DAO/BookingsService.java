package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Booking;
import andreamarchica.GestionePrenotazioni.entities.Location;
import andreamarchica.GestionePrenotazioni.entities.User;
import andreamarchica.GestionePrenotazioni.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BookingsService {
    @Autowired
    private BookingsDao bookingsDao;
    public void saveBooking(Booking booking) {
        bookingsDao.save(booking);
    }
    public Booking findById(long id) throws NotFoundException {
        return bookingsDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Booking> findAll() {
        return bookingsDao.findAll();
    }

    public Booking findByIdAndDelete(long id) {
        Booking found = this.findByIdAndDelete(id);
        bookingsDao.delete(found);
        log.info("Booking with id " + id + " eliminated successfully!");
        return found;
    }

    public void findByIdAndUpdate(long id, Booking booking) {
        Booking found = this.findById(id);
        found.setBookingDate(booking.getBookingDate());
        found.setLocation(booking.getLocation());
        found.setUser(booking.getUser());
        found.setLeavingDate(booking.getLeavingDate());
        bookingsDao.save(found);
        log.info("Building with id " + id + " updated successfully!");
    }

    public void takeBooking(User user, Location location, LocalDate start) {
        Booking booking = new Booking(LocalDate.now(), start.plusDays(1), user, location);

        if (!location.isFree()) {
            System.out.println("Location already booked");
        } else if (!user.getBookingList().isEmpty()) {
            System.out.println("User already has a reservation");
        } else {
            bookingsDao.save(booking);
            location.setFree(false);
        }
    }
}

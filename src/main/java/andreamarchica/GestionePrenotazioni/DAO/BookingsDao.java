package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Booking;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingsDao extends JpaRepository<Booking, Long> {
    List<Booking> findById(long id);

    List<Booking> findByBookingDate(LocalDate date);

    List<Booking> findByLocation(Location location);
}
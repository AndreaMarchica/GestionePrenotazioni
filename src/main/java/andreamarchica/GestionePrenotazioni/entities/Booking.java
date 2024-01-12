package andreamarchica.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Getter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate bookingDate;
    private LocalDate leavingDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Booking() {
    }

    public Booking(LocalDate bookingDate, LocalDate leavingDate, User user, Location location) {
        this.bookingDate = bookingDate;
        this.leavingDate = leavingDate;
        this.user = user;
        this.location = location;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setLeavingDate(LocalDate leavingDate) {
        this.leavingDate = leavingDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
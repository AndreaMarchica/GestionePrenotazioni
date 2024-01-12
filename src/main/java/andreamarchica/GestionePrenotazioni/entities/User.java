package andreamarchica.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String completeName;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList;

    public User() {
    }

    public User(String username, String completeName, String email) {
        this.username = username;
        this.completeName = completeName;
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}

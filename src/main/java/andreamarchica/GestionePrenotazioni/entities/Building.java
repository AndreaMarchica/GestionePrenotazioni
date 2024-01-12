package andreamarchica.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@ToString
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "building")
    private List<Location> locationList;

    public Building() {
    }

    public Building(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
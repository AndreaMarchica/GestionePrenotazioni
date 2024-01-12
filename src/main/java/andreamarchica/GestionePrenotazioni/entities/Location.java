package andreamarchica.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "location_type")
    private LocationType locationType;
    private int maxPeople;
    private  boolean isFree;
    @OneToMany(mappedBy = "location")
    private List<Booking> bookingList;
    @ManyToOne
    @JoinColumn(name = "building_id")
    private  Building building;

    public Location() {
    }

    public Location(String description, LocationType locationType, int maxPeople, boolean isFree, Building building) {
        this.description = description;
        this.locationType = locationType;
        this.maxPeople = maxPeople;
        this.isFree = isFree;
        this.building = building;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}

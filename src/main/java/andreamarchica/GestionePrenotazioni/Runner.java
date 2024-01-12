package andreamarchica.GestionePrenotazioni;

import andreamarchica.GestionePrenotazioni.DAO.BookingsService;
import andreamarchica.GestionePrenotazioni.DAO.BuildingsService;
import andreamarchica.GestionePrenotazioni.DAO.LocationsService;
import andreamarchica.GestionePrenotazioni.DAO.UsersService;
import andreamarchica.GestionePrenotazioni.entities.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    BuildingsService buildingsService;
    @Autowired
    UsersService usersService;
    @Autowired
    LocationsService locationsService;
    @Autowired
    BookingsService bookingsService;
    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        Building building1 = new Building(faker.company().name(), faker.address().streetAddress(), faker.address().city());
        Building building2 = new Building(faker.company().name(), faker.address().streetAddress(), faker.address().city());
        Building building3 = new Building(faker.company().name(), faker.address().streetAddress(), faker.address().city());
        buildingsService.saveBuilding(building1);
        buildingsService.saveBuilding(building2);
        buildingsService.saveBuilding(building3);

        User user1 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        User user2 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        User user3 = new User(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
        usersService.saveUser(user1);
        usersService.saveUser(user2);
        usersService.saveUser(user3);

        Location location1 = new Location("Wide Meeting Room by the sea", LocationType.MEETING_ROOM,  30, true, building1);
        Location location2 = new Location("Public Room in the center of the city", LocationType.OPEN_SPACE,  20, true, building2);
        Location location3 = new Location("Private Room for all your needs", LocationType.PRIVATE,  10, true, building3);
        Location location4 = new Location("Private and intimate room", LocationType.PRIVATE,  4, true, building3);
        Location location5 = new Location("Private Location with coffee break room", LocationType.PRIVATE,  10, true, building1);
        locationsService.saveLocation(location1);
        locationsService.saveLocation(location2);
        locationsService.saveLocation(location3);
        locationsService.saveLocation(location4);
        locationsService.saveLocation(location5);

        Booking booking1 = new Booking(LocalDate.now(), LocalDate.now().plusDays(1), user1, location4);
        Booking booking2 = new Booking(LocalDate.now(), LocalDate.now().plusDays(1), user2, location1);
        bookingsService.saveBooking(booking1);
        bookingsService.saveBooking(booking2);

        bookingsService.takeBooking(user2, location3, LocalDate.now());
    }
}

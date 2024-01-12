package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Location;
import andreamarchica.GestionePrenotazioni.entities.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationsDao extends JpaRepository<Location, Long> {
    List<Location> findByType(LocationType locationType);

    List<Location> findByMaxPeople(int maxPeople);

    List<Location> findByIfIsItFree(boolean isFree);
}


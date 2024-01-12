package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Location;
import andreamarchica.GestionePrenotazioni.entities.LocationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocationsDao extends JpaRepository<Location, Long> {
    List<Location> findByLocationType(LocationType locationType);

    List<Location> findByMaxPeople(int maxPeople);

    List<Location> findByIsFree(boolean isFree);
}


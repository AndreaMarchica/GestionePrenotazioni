package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsDao extends JpaRepository<Location, Long> {
}


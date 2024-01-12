package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingsDao extends JpaRepository<Building, Long> {
    List<Building> findByName(String name);

    List<Building> findByCity(String cities);

    List<Building> findByAddress(String address);

}

package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Building;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuildingsService {
    @Autowired
    private BuildingsDao buildingsDao;
    public void saveBuilding(Building building) {
        buildingsDao.save(building);
    }
}

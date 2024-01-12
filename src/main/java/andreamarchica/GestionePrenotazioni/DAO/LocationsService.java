package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Location;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LocationsService {
    @Autowired
    private LocationsDao locationDao;
    public void  saveLocation(Location location) {
        locationDao.save(location);
    }
}

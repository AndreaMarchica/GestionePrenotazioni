package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Location;
import andreamarchica.GestionePrenotazioni.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LocationsService {
    @Autowired
    private LocationsDao locationDao;
    public void  saveLocation(Location location) {
        locationDao.save(location);
    }
    public Location findById(long id) throws NotFoundException {
        return locationDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Location> findAll() {
        return locationDao.findAll();
    }

    public Location findByIdAndDelete(long id) {
        Location found = this.findByIdAndDelete(id);
        locationDao.delete(found);
        log.info("Location with id " + id + " eliminated successfully!");
        return found;
    }

    public void findByIdAndUpdate(long id, Location location) {
        Location found = this.findById(id);
        found.setBuilding(location.getBuilding());
        found.setDescription(location.getDescription());
        found.setLocationType(location.getLocationType());
        found.setMaxPeople(location.getMaxPeople());
        locationDao.save(found);
        log.info("Location with id " + id + " updated successfully!");
    }
}

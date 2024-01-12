package andreamarchica.GestionePrenotazioni.DAO;

import andreamarchica.GestionePrenotazioni.entities.Building;
import andreamarchica.GestionePrenotazioni.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BuildingsService {
    @Autowired
    private BuildingsDao buildingsDao;
    public void saveBuilding(Building building) {
        buildingsDao.save(building);
    }
    public Building findById(long id) throws NotFoundException {
        return buildingsDao.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Building> findAll() {
        return buildingsDao.findAll();
    }

    public Building findByIdAndDelete(long id) {
        Building found = this.findByIdAndDelete(id);
        buildingsDao.delete(found);
        log.info("Building with id " + id + " eliminated successfully!");
        return found;
    }

    public void findByIdAndUpdate(long id, Building building) {
        Building found = this.findById(id);
        found.setAddress(building.getAddress());
        found.setCity(building.getCity());
        found.setName(building.getName());
        buildingsDao.save(found);
        log.info("Building with id " + id + " updated successfully!");
    }
}

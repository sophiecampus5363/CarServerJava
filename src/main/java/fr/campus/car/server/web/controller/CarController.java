package fr.campus.car.server.web.controller;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fr.campus.car.server.dao.CarDao;
import fr.campus.car.server.model.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api (description ="API pour les opérations CRUD sur les voitures")
@RestController
public class CarController {

    @Autowired
    private CarDao carDao;

    /*
     * GET /cars
     * Liste de toutes les voitures
     */
    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public MappingJacksonValue listeCars() {
        Iterable<Car> cars                  = carDao.findAll();
        SimpleBeanPropertyFilter monFiltre  = SimpleBeanPropertyFilter.serializeAllExcept("carMaker");
        FilterProvider listDeNosFiltres     = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
        MappingJacksonValue carsFiltres     = new MappingJacksonValue(cars);
        carsFiltres.setFilters(listDeNosFiltres);

        return carsFiltres;
    }

    /*
     * GET /car/1
     * Afficher une voiture ou deux
     */
    @GetMapping(value = "/car/{id}")
    public Car show(@PathVariable int id) {
        return carDao.findById(id);

    }

    /*
     * GET /filterPrice/car/30000
     * Filtre qui affiche les voitures dont le prix > priceLimit
     */
    @GetMapping(value = "filterPrice/car/{priceLimit}")
    public List<Car> testDeRequete(@PathVariable int priceLimit) {
        return carDao.findByPriceGreaterThan(priceLimit);
    }

    /*
     * GET /filterMark/car/Tes
     * Filtre qui affiche les voitures dont la marque contient "Tes"
     */
    @GetMapping(value = "filterMark/car/{search}")
    public List<Car> testingDeRequete(@PathVariable String search) {
        return carDao.findByCarMakerLike("%" + search + "%");
    }

    /*
     * Old DAO method
     *
    // Récupérer la liste des voitures
    @RequestMapping(value="/car", method= RequestMethod.GET)
    public List<Car> listeVoitures() {
        return carDao.findAll();
    }

    // Récupérer une voiture par son id
    @ApiOperation(value = "Récupère une voiture grâce à son ID à condition que celle-ci soit en stock")
    @GetMapping(value="/car/{id}")
    public Car afficherUneVoiture(@PathVariable int id) {
        return carDao.findById(id);
    }

    // Ajouter une voiture
    @PostMapping(value = "/car")
    public void ajouterVoiture(@RequestBody Car car) {
        carDao.save(car);
    }

    // Modifier une voiture
    @PutMapping(value = "/car/{id}")
    public void modifierVoiture(@RequestBody Car car) { carDao.update(car.getId(), car); }

    // Supprimer une voiture
    @DeleteMapping(value = "/car/{id}")
    public void supprimerVoiture(@PathVariable int id) { carDao.delete(id); }
    */
}

// Tu fais un getmapping sur ton /delete/{id} , envoie un delete au back
// parce que ce n'est pas possible de faire autre chose que get et post
// en html normalement

// put -> technique des headers
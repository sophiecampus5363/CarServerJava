package fr.campus.car.server.web.controller;
import fr.campus.car.server.dao.CarDao;
import fr.campus.car.server.model.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static fr.campus.car.server.dao.CarDaoImpl.cars;

@Api (description ="API pour les opérations CRUD sur les voitures")
@RestController
public class CarController {

    @Autowired
    private CarDao carDao;

    //Récupérer la liste des voitures
    @RequestMapping(value="/car", method= RequestMethod.GET)
    public List<Car> listeVoitures() {
        return carDao.findAll();
    }

    //Récupérer une voiture par son Id
    @ApiOperation(value = "Récupère une voiture grâce à son ID à condition que celle-ci soit en stock")
    @GetMapping(value="/car/{id}")
    public Car afficherUneVoiture(@PathVariable int id) {
        return carDao.findById(id);
    }

    //ajouter une voiture
    @PostMapping(value = "/car")
    public void ajouterVoiture(@RequestBody Car car) {
        carDao.save(car);
    }

    //modifier une voiture
    @PutMapping(value = "/car")
    public void modifierVoiture(@RequestBody Car car) {
        carDao.(car);
    }


}

// Tu fais un getmapping sur ton /delete/{id} , envoie un delete au back
// parce que ce n'est pas possible de faire autre chose que get et post
// en html normalement

// put -> technique des headers
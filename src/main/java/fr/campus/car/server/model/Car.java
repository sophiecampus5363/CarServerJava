package fr.campus.car.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // Permet de prendre en compte la classe, évite d'utiliser persistence.xml
public class Car {

    // On annote id avec @Id et @GeneratedValue afin qu'il soit identifié en tant que clé unique auto-générée
    @Id
    @GeneratedValue
    private int id;

    private String carMaker;
    private String carModel;
    private int price;

    public Car() {}

    public Car(int id, String carMaker, String carModel, Integer price) {
        this.id       = id;
        this.carMaker = carMaker;
        this.carModel = carModel;
        this.price    = price;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(String carMaker) {
        this.carMaker = carMaker;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Car{"+
                "id=" + id +
                ", carMaker='"+ carMaker + '\'' +
                ", carModel=" + carModel + '}' +
                ", price=" + price + '}';
    }
}

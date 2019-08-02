package service;

import common.OracleJPA;
import entity.Car;
import entity.Person;
import repository.CarRepository;
import repository.PersonRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class CarService {
    private static CarService carService = new CarService();

    private CarService() {

    }

    public static CarService getInstance() {
        return carService;
    }

    public void saveOrUpdate(Car car) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        CarRepository repo = new CarRepository(em);
        //if(car.getId()==null)  //new obj --> persist
        repo.save(car);
//        else
//            repo.update(person); // not new obj, we use merge instead of persist, as the objects is detached
    }

    public void delete(Car car) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        CarRepository repo = new CarRepository(em);
        repo.delete(car);
    }

    public List<Car> findAll() {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        CarRepository repo = new CarRepository(em);
        return repo.findAllByNQ();
    }

    public Car findById(int id) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        CarRepository repo = new CarRepository(em);
        return repo.findById(id);
    }


    public List<Car> findCarsByPersonJoin(int pid) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        CarRepository repo = new CarRepository(em);
        return repo.findCarsByPersonJoin(pid);
    }
    public List<Car> findCarsByPersonJoinFetch(int pid) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        CarRepository repo = new CarRepository(em);
        return repo.findCarsByPersonJoinFetch(pid);
    }

}

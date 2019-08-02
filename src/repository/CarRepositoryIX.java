package repository;

import entity.Car;
import entity.Person;

import java.util.List;

public interface CarRepositoryIX {


    public void save(Car car);
    public void update(Car car);
    public void delete(Car car);
    public List<Car> findAllByNQ();
    public List<Car> findByModel_JPQL(String Model);
    public Car findById(int id);
    public List<Car> findCarsByPersonJoinFetch(long pid);
    public List<Car> findCarsByPersonJoin(long pid);


}

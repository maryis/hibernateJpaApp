package controller;

import entity.Car;
import entity.Person;
import service.CarService;
import service.PersonService;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        PersonService personService = PersonService.getInstance();
        CarService carService = CarService.getInstance();

        Person person = new Person();
//
////        System.out.println("persist a person:");
////        person.setName("dfg");
////        person.setPass("ZSdfzsdf");
////        personService.saveOrUpdate(person);
//
//        System.out.println("find and update a person:");
//        List<Person> list = personService.findByName("sdf");
//        if (list.size() > 0) {
//            Person p1 = list.get(0);
//            p1.setName("hesam");
//            personService.saveOrUpdate(p1);
//        }
//
////        System.out.println("Persist with manual Id while it is based on seq!:");
////        List<Person> list = personService.findByName("sdf");
////        Person p1 = list.get(0);
////        p1.setId(new Long(123));//it executed without error, but the id in DB is strange!!
////        personService.saveOrUpdate(p1);
//
//        System.out.println("find all:");
//        List<Person> list1 = personService.findAll();
//        list1.forEach(item -> System.out.println(item.getId() + "  " + item.getName()));
//
//        System.out.println("find by id:");
//        Person item = personService.find(new Long(1));
//        List<Car> citemCar = carService.findCarsByPersonJoin(1);
////        List<Car> citemCar = carService.findCarsByPersonJoinFetch(1);//it does not work
//        System.out.println(citemCar.size());
//        System.out.println(item.getId() + "  " + item.getName());
//        citemCar.forEach(c -> System.out.println(c.getId() + "  " + c.getModel()));
//
//
//        System.out.println("batch update:");
//        personService.resetPersonPass();


//        Car car = new Car();
//        car.setModel("new1");
//        person.setName("myself1");
//        person.setCars(Arrays.asList(car));
//        personService.saveOrUpdate(person);

//        person.setPass("new pass");
//        person.setId((long) 1);
//        personService.resetOnePass(person);

        List<Car> cars=carService.findAll();
        cars.forEach(c-> System.out.println(c.getModel()));

    }
}

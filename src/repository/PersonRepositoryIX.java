package repository;

import entity.Person;

import javax.persistence.EntityManager;
import java.util.List;

public interface PersonRepositoryIX {


    public void save(Person person);
    public void update(Person person);
    public void delete(Person person);
    public List<Person> findAllByJPQL();
    public List<Person> findByName_JPQL(String name);
    public Person findById(Long id);
    public void resetAllPass();
    public void resetOnePass_NQ(Person person);

}

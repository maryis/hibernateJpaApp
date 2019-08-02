package service;

import common.OracleJPA;
import entity.Person;
import repository.PersonRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonService { //singletone because it is stateless
    private static PersonService personService = new PersonService();

    private PersonService() {

    }

    public static PersonService getInstance() {
        return personService;
    }

    public void saveOrUpdate(Person person) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        PersonRepository repo = new PersonRepository(em);
        if(person.getId()==null)  //new obj --> persist
                repo.save(person);
        else
            repo.update(person); // not new obj, we use merge instead of persist, as the objects is detached
    }

    public void delete(Person person) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        PersonRepository repo = new PersonRepository(em);
        repo.delete(person);
    }

    public List<Person> findAll() {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        PersonRepository repo = new PersonRepository(em);
        return repo.findAllByJPQL();
    }

    public List<Person> findByName(String name) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        PersonRepository repo = new PersonRepository(em);
        return repo.findByName_JPQL(name);
    }

    public Person find(Long id) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        PersonRepository repo = new PersonRepository(em);
        return repo.findById(id);
    }

    public void resetPersonPass() {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        PersonRepository repo = new PersonRepository(em);
        repo.resetAllPass();
    }
    public void resetOnePass(Person p) {
        EntityManager em = OracleJPA.getFactory().createEntityManager();
        PersonRepository repo = new PersonRepository(em);
        repo.resetOnePass_NQ(p);
    }
}

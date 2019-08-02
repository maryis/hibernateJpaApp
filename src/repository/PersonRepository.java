package repository;

import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PersonRepository implements PersonRepositoryIX {
    //hql: existed in pure hibernate. now it is depricated
    //jpql: java persistence query language :  very similar to SQL (join,having,order
    // A JPQL query is always a valid HQL query, the reverse is not true however.

    private EntityManager em;
    private EntityTransaction et;

    public PersonRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Person person) {
        et = em.getTransaction();

        et.begin();
        em.persist(person);

        et.commit();
        em.close();
    }
  @Override
    public void update(Person person) {
        et = em.getTransaction();

        et.begin();
        em.merge(person); //if id exist:update else: insert
      //or we can use find-persist instead of merge

        et.commit();
        em.close();
    }

    @Override
    public void delete(Person person) {
        et = em.getTransaction();

        et.begin();
        em.remove(person);

        et.commit();
        em.close();

    }

    @Override
    public List<Person> findAllByJPQL() {

        List<Person> personList;
//        Query query = em.createQuery("select a from person a");
//       personList= query.getResultList();
//or :
        personList=em.createNamedQuery("findAllPerson",Person.class).getResultList();
        em.close();
        return personList;
    }

    @Override
    public Person findById(Long id) {

        Person p= em.find(Person.class,id);
        em.close();
        return p;
    }

    @Override
    public List<Person> findByName_JPQL(String name) {

        Query query = em.createQuery("select a from person a where a.name like :n");
        query.setParameter("n","%"+name+"%");
        List<Person> personList = query.getResultList();

        em.close();
        return personList;
    }

    @Override
    public void resetAllPass() {
        EntityTransaction trans=em.getTransaction();
        trans.begin();
        Query query=em.createQuery("update person p set p.pass=''");
        query.executeUpdate();
        trans.commit();
        em.close();

    }

    @Override
    public void resetOnePass_NQ(Person person) {
        et=em.getTransaction();
        et.begin();
         int result=em.createNamedQuery("resetOnePass").setParameter("id",person.getId()).executeUpdate();
         et.commit();
         em.close();
        System.out.println(result + " records has been updated");

    }
}

package repository;

import entity.Car;
import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class CarRepository implements CarRepositoryIX {
    //hql: existed in pure hibernate. now it is deprecated
    //jpql: java persistence query language :  very similar to SQL (join,having,order
    // A JPQL query is always a valid HQL query, the reverse is not true however.

    private EntityManager em;
    private EntityTransaction et;

    public CarRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Car car) {
        et = em.getTransaction();
        et.begin();
        em.persist(car);
        et.commit();
        em.close();

    }

    @Override
    public void update(Car car) {
        et = em.getTransaction();
        et.begin();
        Car car1 = em.find(Car.class, car.getId());
        car1.setModel(car.getModel());
        em.merge(car1);
        et.commit();
        em.close();

    }

    @Override
    public void delete(Car car) {

        //  et=em.getTransaction();
        //  et.begin();
        em.remove(car);
        //  et.commit();
        em.close();

    }

    @Override
    public List<Car> findAllByNQ() {
        return em.createNamedQuery("findAll", Car.class).getResultList();
    }

    @Override
    public List<Car> findByModel_JPQL(String model) {
        Query nq = em.createQuery("select c from car c where c.model=:model");
        nq.setParameter("model", model);
        return nq.getResultList();

    }

    @Override
    public Car findById(int id) {
        return em.find(Car.class, id);
    }

    @Override
    public List<Car> findCarsByPersonJoinFetch(long pid) {

//        After all this turned out to be a persistence context live cycle problem. The entity definition and the criteria query are perfectly fine.
//
//        Background
//
//        Our handcrafted test-JEE container does not clear the persistence context in this particular case. Further more the DB initialization code did not set both sides of the bidirectional relation between Bp and BpHistorisert. This caused the entity manager to work with the a broken Bp to BpHistorisert relation from the persistence context instead of reading everything from scratch from the DB

        //it does not work because of above descriptions
        List<Person> p = em.createQuery("select p from person p join fetch p.cars c where p.id=:id").setParameter("id", pid).getResultList();
        if (p.size() > 0)
            return p.get(0).getCars();
        else
            return null;
    }

    @Override
    public List<Car> findCarsByPersonJoin(long pid) {
        //when we use native query, we should !!!!!!!!resultsetmapping!!!!!!! to map the result to a target class
        //otherwise the result would be List<Object>
//        List<Person> p= em.createNativeQuery("select * from carTbl c , personTbl p  where c.p_id=p.id and p.id =:id").setParameter("id", pid).getResultList();
        List<Person> p = em.createQuery("select p from person p left join fetch p.cars c  where  p.id =:id").setParameter("id", pid).getResultList();
        if (p.size() > 0)
            return p.get(0).getCars();
        else
            return null;
    }
}

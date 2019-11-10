package entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "person")//jpql
@Table(name = "personTbl")

@NamedQueries({@NamedQuery(name = "findAllPerson", query = "select e from person e "),
@NamedQuery(name = "resetOnePass",query = "update person p set p.pass='123' where p.id=:id")}) //jpql
//or
//@NamedNativeQueries(..)

public class Person {

    @Id
    @Column(name = "id", updatable = false, nullable = false) //optional for same name

    // @GeneratedValue(strategy = GenerationType.AUTO)//lets the persistence provider choose the generation strategy.if pp is JPAHibernate, for most popular DBs strategy=Sequence will be selecte
    // Long id;

    @SequenceGenerator(name = "myGenerator", sequenceName = "mySeq", initialValue = 1, allocationSize = 1)//allocationSize=increment by
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myGenerator")//if no sequence_generator mentioned, it uses the default sq
    private Long id;

    @Column(name = "name", columnDefinition = "varchar2(20)") //if we do not call name, the table name and field name would be the same
    private String name;

    //    public Person(String name,Long id) {
//        this.name = name;
//        this.id=id;
//    }
//    public Person(String name) {
//        this.name = name;
//    }

    @Column(name="sys_pass",columnDefinition = "VARCHAR2(20)")
    private String pass;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//it also allows to have no person for a car
    @JoinTable(name = "cptbl")
    List<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

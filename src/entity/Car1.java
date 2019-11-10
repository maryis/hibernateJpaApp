package entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "car")
@Table(name = "carTbl")

@NamedQuery(name="findAll",query = "select c from car c")

public class Car {

    @SequenceGenerator(name = "myGenerator", sequenceName = "newSeq") //it seams that default allocation size(steps) is 50

    @Id
    @Column(name = "card_id")
    @GeneratedValue(generator = "myGenerator", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "model", columnDefinition = "VARCHAR2(20)")
    private String model;

    @ManyToMany(mappedBy = "cars")
    List<Person> persons;

    @Version
    private int rv;

    public int getRv() {
        return rv;
    }

    public void setRv(int rv) {
        this.rv = rv;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}

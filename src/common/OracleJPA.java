package common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OracleJPA { //singletone

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("myOracleDB");
    }
    public static EntityManagerFactory getFactory()
    {
        return entityManagerFactory;
    }
}

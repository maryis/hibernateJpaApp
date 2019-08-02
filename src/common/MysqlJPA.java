package common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MysqlJPA { //singletone

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("myMysqlDB");
    }
    public static EntityManagerFactory getFactory()
    {
        return entityManagerFactory;
    }
}

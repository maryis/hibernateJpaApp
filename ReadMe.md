we can define one persistence-unit for each db that we have in our persistence.xml
when we have two persistence-unit we should use @PersistenceContext(unitName="...") (in spring of course :))

I use OneToMany relations always with cascadeAll,fetch Lazy
and then I use namedQuery with join fetch to get an entity with its dependencies

jpa methods on EntityManager:
detach
persist
remove
merge
find
createQuery (we can set parameters for it)
createNamedQuery (I always define named queries in Entity)(we can set parameters for it)

note: 
- we can use @SqlResultSetMapping to map the result of a query to a java object

- do not forget transaction.begin for changes 
- changes on an attached object in the scope of EM affect the DB
---------------------Query Languages------------------------------------
3 ways to do a query operation:
- jpql: jpa QL --> non-type-safe
- Hql : Hibernate QL --> non-type-safe
- Criteria  --> type-safe 
a jpql is always a valid hql but the reverse is not true

* HQL is much easier to read, easier to debug using tools like the Eclipse Hibernate plugin, and easier to log. Criteria queries are better for building dynamic queries where a lot of the behavior is determined at runtime and dynamic queries (based on user inputs) and is slower than Hql






when we have two persistence-unit we should use @PersistenceContext(unitName="...") (in spring of course :))
we can define one persistence-unit for each db we have in our persistence.xml

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



we can define one persistence-unit for each db that we have in our persistence.xml
when we have two persistence-unit we should use @PersistenceContext(unitName="...") (in spring of course :))
----------------handling relations ------------------
I use OneToMany relations always with cascadeAll,fetch Lazy
and then I use namedQuery with join fetch to get an entity with its dependencies
in this projects in the folder entity, files x1 shows tested bidirectional entities
-------   ------jpa methods on EntityManager-----------------------------
detach
persist
remove
merge
find
createQuery (we can set parameters for it)
createNamedQuery (I always define named queries in Entity)(we can set parameters for it)

note: 
- we can use @SqlResultSetMapping to map the result of a sql query to a java object
- do not forget transaction.begin for changes 
- changes on an attached object in the scope of EM affect the DB
---------------------Query Languages------------------------------------
3 ways to do a query operation:
- jpql: jpa QL --> non-type-safe
- Hql : Hibernate QL --> non-type-safe
- Criteria API --> type-safe 
note:
- A jpql is always a valid hql but the reverse is not true
- HQL is much easier to read, easier to debug using tools like the Eclipse Hibernate plugin, and easier to log. 
- Criteria queries are better for building dynamic queries where a lot of the behavior is determined at runtime 
and dynamic queries (based on user inputs) but is slower than Hql.
------------------criteria API--------------------------------------
The following simple criteria query returns all instances of the entity class in the data source.

EntityManager em = ...;
CriteriaBuilder cb = em.getCriteriaBuilder();

CriteriaQuery<Entity class> cq = cb.createQuery(Entity.class);
Root<Entity> from = cq.from(Entity.class);

cq.select(Entity);
TypedQuery<Entity> q = em.createQuery(cq);
List<Entity> allitems = q.getResultList();


1) for select :
         cq.select(stud.get("s_name"));   
2) for multi coulumn select:
         cq.multiselect(stud.get("s_id"),stud.get("s_name"),stud.get("s_age") );  
3) for ordering:
         cq.orderBy(cb.asc(stud.get("s_age")));  
         cq.orderBy(cb.desc(stud.get("s_age")));  
4) for conditions:
         cq.where(cb.between(stud.get("s_age"), 22, 26)) ;  
         cq.where(cb.greaterthan(stud.get("s_age"), 22)) ;  
5) group by
         cq.multiselect(stud.get("s_age"),cb.count(stud)).groupBy(stud.get("s_age"));  

....


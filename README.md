# Spring-Boot---DataJPA

<div style="display: flex;">
    <!-- SPRING BOOT LOGO -->
    <a href="https://spring.io/projects/spring-boot/">
            <img src="https://4.bp.blogspot.com/-ou-a_Aa1t7A/W6IhNc3Q0gI/AAAAAAAAD6Y/pwh44arKiuM_NBqB1H7Pz4-7QhUxAgZkACLcBGAs/s1600/spring-boot-logo.png" alt="SPRING BOOT LOGO" height="55" />
    </a>&nbsp;
    <!-- MYSQL LOGO -->
    <a href="https://www.mysql.com/">
        <img src="https://sujanbyanjankar.com.np/wp-content/uploads/2023/06/mysql-ar21.png" alt="MYSQL LOGO" height="55" />
    </a>
</div>

---

# SPRING BOOT ANNOTATIONS

## Entity

@Entity is an annotation used in spring boot to define a Java class as a database entity, enabling it to be mapped and stored in a relational database table

## Id

@Id is a simple annotation used in spring boot to mark a field as the unique identifier for an object in databases.

## SequenceGenerator

@SequenceGenerator is an annotation used in code to customize the generation of primary key values for entities in JPA (Java Persistence API) by specifying a named sequence in the database

```
name: The name of the sequence generator.

sequenceName: The name of the database sequence.

allocationSize: The amount by which the sequence is incremented for each allocation (default is 50).
```

## GeneratedValue

The @GeneratedValue annotation in JPA automates primary key generation for entities. Strategies like `AUTO` (automatic selection), IDENTITY (auto-increment), `SEQUENCE` (database sequence), TABLE (separate table), and NONE (manual assignment) define how keys are generated.

generator = SequenceGenerator name

```
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
```

## Column

The @Column annotation in JPA is used to customize the mapping of a field or property to a database column. It allows you to define various attributes such as the `column name`, data type, length, `nullable`, and more, for better control over the database schema.

## Table

The @Table annotation in JPA is used to customize the mapping of an entity class to a database table. It allows you to define various attributes such as the table `name`, schema, catalog, and `unique constraints`, providing better control over the database schema and table mapping.

## AttributeOverrides

The @AttributeOverrides annotation in JPA allows customizing attribute mappings for embedded objects or embedded IDs. It provides fine-grained control by overriding specific attribute settings, enhancing flexibility in database schema design.

```
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "guardianName")),
})

public class Guardian {

    private String name;
}
```

## Embedded

@Embedded annotation in JPA simplifies data modeling by including fields of an embedded object directly in the owning entity's table. It allows object composition, making the database schema more straightforward and intuitive.

```
@Embedded
private Guardian guardian;
```

## OneToOne

The @OneToOne annotation in JPA represents a simple one-to-one relationship between two entities, where each entity is associated with exactly one instance of the other.

```
@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
```

### `unidirectional`

`cascade = CascadeType.ALL:`

It means that when a particular operation (e.g., save, update, delete) is performed on the parent entity, the same operation will be cascaded to the associated (related) entity as well.
For example, if you save the parent entity, the related entity will also be saved automatically.

`fetch = FetchType.LAZY:`

It defines how the associated (related) entity is fetched from the database.
With LAZY, the related entity is loaded only when you explicitly access it in your code, saving unnecessary database queries if you don't need the related entity's data.

### `bidirectional`

`optional = false:`

It indicates whether the relationship is required or not.
With optional = false, the relationship is mandatory, and the associated (related) entity must always be present (not null) in the database. It cannot be empty or null.

`mappedBy = 'course' `

The @OneToOne(mappedBy = "course") annotation in JPA creates a bidirectional one-to-one relationship between two entities. It means the "course" attribute in the target entity is responsible for managing the association, and it maps to the owning side of the relationship.

## JoinColumn

The @JoinColumn annotation in JPA is used to customize the foreign key column name and its attributes when establishing a relationship between two entities in the database. It provides more control over the database schema and association mapping.

name = table column name;

referencedColumnName = entity column name

```
@JoinColumn(name = "course_id", referencedColumnName = "courseId")
```

## OneToMany

The @OneToMany annotation in JPA creates a one-to-many relationship between two entities. It means one entity can be associated with multiple instances of another entity, represented as a collection (e.g., List or Set) in the owning entity.

## ManyToOne

The @ManyToOne annotation in JPA represents a relationship where many instances of one entity are associated with a single instance of another entity. It's like many entities pointing to one entity, representing a foreign key relationship.

Important:

`In a given relationship between two entities, you can only have one of these annotations (@ManyToOne or @OneToMany), not both. The choice depends on the direction of the association and which entity holds the foreign key.`

## JoinTable

The @JoinTable annotation in JPA is used to define the many-to-many relationship between two entities. It is typically used in combination with the @ManyToMany annotation. It allows you to specify the name of the join table and the names of the columns used to link the two entities. This annotation is used on the owning side of the relationship.

```
@JoinTable(
    name = "student_course_map",
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
)
```

# ADDITIONAL KNOWLEDGE

### `CascadeType`

In JPA (Java Persistence API), CascadeType is an enumeration that defines the cascade operations to be applied to associated entities when performing certain operations on the owning entity (parent entity). It is used in the context of relationships between entities, such as @OneToMany, @ManyToOne, @OneToOne, etc.

Here are the commonly used values for CascadeType:

1. CascadeType.ALL: This means that all cascade operations should be applied to the associated entities. It includes PERSIST, MERGE, REMOVE, REFRESH, and DETACH.

2. CascadeType.PERSIST: This specifies that the PERSIST operation should be cascaded to the associated entities. It means that when the owning entity is persisted (saved), the associated entities will also be persisted.

3. CascadeType.MERGE: This specifies that the MERGE operation should be cascaded to the associated entities. It means that when the owning entity is merged (updated), the associated entities will also be merged.

4. CascadeType.REMOVE: This specifies that the REMOVE operation should be cascaded to the associated entities. It means that when the owning entity is removed (deleted), the associated entities will also be removed.

5. CascadeType.REFRESH: This specifies that the REFRESH operation should be cascaded to the associated entities. It means that when the owning entity is refreshed (reloaded from the database), the associated entities will also be refreshed.

6. CascadeType.DETACH: This specifies that the DETACH operation should be cascaded to the associated entities. It means that when the owning entity is detached (disconnected from the persistence context), the associated entities will also be detached.

### `FetchType`

fetch = FetchType.LAZY in Hibernate means related data is not fetched immediately when the main entity is loaded. Instead, it is fetched on-demand when accessed for the first time. This is useful for optimizing performance and reducing unnecessary database queries. Lazy loading is the default behavior for most associations in Hibernate.

```
@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
```

fetch = FetchType.EAGER in Hibernate means related data is fetched immediately along with the main entity. It's like getting everything at once, useful if you always need all data. Be careful with large datasets to avoid performance issues.

```
@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
```

# SPRING BOOT JPA QUERIES

## JPQL

JPQL (Java Persistence Query Language) is a query language in JPA (Java Persistence API). It lets you write database queries using Java syntax, making it easy to retrieve, update, and delete data from a database using object-oriented code. It provides a database-agnostic way to work with databases in Java applications.

```
@Query("SELECT p FROM Product p WHERE p.category = :category")
List<Product> findByCategory(@Param("category") String category);
```

```
@Query("SELECT p FROM Product p WHERE p.price > :price")
List<Product> findByPriceGreaterThan(@Param("price") double price);
```

```
@Query("SELECT COUNT(p) FROM Product p")
long countProducts();
```

```
@Query("UPDATE Product p SET p.price = :newPrice WHERE p.category = :category")
@Modifying
void updatePriceByCategory(@Param("category") String category, @Param("newPrice") double newPrice);
```

## NativeQuery

In Spring Boot, a NativeQuery is a way to write custom SQL queries directly in your Java code. It gives you more control over the queries and is useful for complex or database-specific operations. However, be cautious about SQL injection vulnerabilities, so sanitize user inputs and use parameter binding to keep your application secure.

```
@Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
List<Product> findByCategoryNative(@Param("category") String category);
```

```
@Query(value = "SELECT * FROM products WHERE price > :price", nativeQuery = true)
List<Product> findByPriceGreaterThanNative(@Param("price") double price);
```

```
@Query(value = "SELECT COUNT(*) FROM products", nativeQuery = true)
long countProductsNative();
```

```
@Query(value = "UPDATE products SET price = :newPrice WHERE category = :category", nativeQuery = true)
@Modifying
void updatePriceByCategoryNative(@Param("category") String category, @Param("newPrice") double newPrice);

```

## Update NativeQuery

## Modifying

The @Modifying annotation is used in Spring Data JPA to indicate that a repository query method is modifying the data in the database. It is typically used with update or delete operations to indicate that the query will change the data in the database.

## Transactional

The @Transactional annotation in Spring is used to mark a method or class as transactional. Transactions ensure that a group of related database operations are executed as a single unit. If any operation fails, the entire transaction is rolled back, maintaining data consistency.

# Spring-Boot---DataJPA

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

package com.sanish.spring_data_jpa_demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Author.namedQueryFindByAge",
                query = "select a from Author a where a.age = :author_age"
        ),
        @NamedQuery(
                name = "Author.namedQuerySetAllModTime",
                query = "update Author a set a.lastModifiedAt = :time"
        ),
})
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder //Will help us to create a builder pattern for the class for properties initialization
@SuperBuilder
@Entity
@Table(name = "author_tbl")
public class Author extends BaseEntity{ //Each class/table extending BaseEntity will have its fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "author_email", unique = true)
    private String email;

    @Column(name = "author_age")
    private Integer age;

    @JsonManagedReference
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Course> courses;

//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "author_sequence")
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 5)



//    @Column(name = "created_at", updatable = false, nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "last_modified", insertable = false)
//    private LocalDateTime lastModified;
}

package com.sha.microservicecoursemanagement.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data // Lombok annotations to getter and setter methods
@Entity // Database JPA entity annotations, indicates that this class will be a database entity
@Table // Database JPA table annotations, indicates that this class will be a database table
public class Course {

    @Id // Indicates that this column will be unique id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Creates id and increments automatically
    private Long id;

    @Column(name = "title") // Indicates this is a column of database table
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "category")
    private String Category;

    @Column(name = "publish_date")
    private LocalDate publishDate;
}

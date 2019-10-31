package com.sha.microservicecoursemanagement.model;

import liquibase.exception.DatabaseException;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many users can enroll to a course, a course can be taken by many users
    // So the relation between Transaction and Course will be "Many to One"
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date_of_issue")
    private LocalDateTime dateOfIssue;

}


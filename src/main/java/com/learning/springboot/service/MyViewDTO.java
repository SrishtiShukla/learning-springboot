package com.learning.springboot.service;


import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "my_view")
@Data
public class MyViewDTO {

    @Id
    @Column(name = "row_num")
    private Long row_num;
    @Column(name = "author_id")
    private Long author_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "isbn")
    private String isbn;
}

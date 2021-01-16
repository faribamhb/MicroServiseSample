package com.iranargham.first.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Terminal")
public class Terminal implements Serializable {

    @Id
    @SequenceGenerator(name = "terminal_id_seq", sequenceName = "terminal_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_id_seq")
    @Column(name = "terminal_id")
    private Long id;


    @Column(name = "NAME", columnDefinition = "nvarchar2(800)")
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "nvarchar2(800)")
    private String description;

    @Column(name = "ACTIVE")
    private char active;

    public Terminal() {
    }

    public Terminal(Long id, String name, String description, char active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getActive() {
        return active;
    }

    public void setActive(char active) {
        this.active = active;
    }
}

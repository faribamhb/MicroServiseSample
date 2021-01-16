package com.iranargham.first.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Terminal")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Terminal implements Serializable {

    @Id
    @SequenceGenerator(name = "terminal_id_seq", sequenceName = "terminal_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "terminal_id_seq")
    @Column(name = "terminal_id")
    private Long id;


    @Column(name = "Terminalname", columnDefinition = "nvarchar2(800)")
    private String terminalName;

    @Column(name = "DESCRIPTION", columnDefinition = "nvarchar2(800)")
    private String description;

    @Column(name = "ACTIVE")
    private char active;
    @Column(name = "Terminalnumber")
    private Long terminalNumber;


}

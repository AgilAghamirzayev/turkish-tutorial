package com.example.datajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @Enumerated
    private AddressTip addressTip;
    private Boolean active;

    @ManyToOne @JoinColumn
    private Person person;

    public enum AddressTip {
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }
}

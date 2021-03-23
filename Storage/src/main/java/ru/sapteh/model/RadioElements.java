package ru.sapteh.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table (name = "radio_elements")
public class RadioElements {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String manufacturer;
    @Column
    private String description;
    @Column
    private int quantity;
    @Column
    private String cost;
}

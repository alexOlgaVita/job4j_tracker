package ru.job4j.toone;

import lombok.*;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "j_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Include
    private Integer id;

    private String name;
}

package br.com.cinq.spring.data.sample.application.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
public class City {

    @Id
    @GeneratedValue
    private Integer cityId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
        private Country country;
}

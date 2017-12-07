package br.com.cinq.spring.data.sample.application.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor

@Entity
public class Country {

    @Id
    private Integer countryId;

    private String name;
}

package com.example.momondolike.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CombinedResponseEntity {
    @Id
    String name;
    String gender;
    double genderProbability;
    int age;
    int ageCount;
    String country;
    double countryProbability;
    boolean isCached;

    public CombinedResponseEntity(String name, String gender, double genderProbability, int age, int ageCount, String country, double countryProbability, boolean isCached) {
        this.name = name;
        this.gender = gender;
        this.genderProbability = genderProbability;
        this.age = age;
        this.ageCount = ageCount;
        this.country = country;
        this.countryProbability = countryProbability;
        this.isCached = isCached;
    }
}

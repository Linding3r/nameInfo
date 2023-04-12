package com.example.momondolike.dto;

import com.example.momondolike.entity.CombinedResponseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CombinedResponse {
    String name;
    String gender;
    double genderProbability;
    int age;
    int ageCount;
    String country;
    double countryProbability;
    boolean isCached;

    public CombinedResponse(GenderResponse g, AgeResponse a, NationalityResponse n, boolean isCached){
        gender = g.getGender();
        name = g.getName();
        genderProbability = g.getProbability();
        age = a.getAge();
        ageCount = a.getCount();
        country = n.getCountry().get(0).getCountry_id();
        countryProbability = n.getCountry().get(0).getProbability();
        this.isCached = isCached;
    }

    public CombinedResponse(GenderResponse g, AgeResponse a, NationalityResponse n){
        gender = g.getGender();
        name = g.getName();
        genderProbability = g.getProbability();
        age = a.getAge();
        ageCount = a.getCount();
        country = n.getCountry().get(0).getCountry_id();
        countryProbability = n.getCountry().get(0).getProbability();
        this.isCached = true;
    }

    public static CombinedResponseEntity CombinedResponseEntity (CombinedResponse r){
        return new CombinedResponseEntity(r.getName(), r.getGender(), r.getGenderProbability(), r.getAge(), r.getAgeCount(), r.getCountry(), r.getCountryProbability(), r.isCached);
    }
}

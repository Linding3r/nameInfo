package com.example.momondolike.dto;

import com.example.momondolike.entity.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NationalityResponse {
    List<Country> country;
    String name;
}

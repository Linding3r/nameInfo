package com.example.momondolike.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AgeResponse {
    int age;
    String name;
    int count;

    public AgeResponse(int age, String name, int count){
        this.age = age;
        this.name = name;
        this.count = count;
    }
}


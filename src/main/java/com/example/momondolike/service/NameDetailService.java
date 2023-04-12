package com.example.momondolike.service;

import com.example.momondolike.dto.AgeResponse;
import com.example.momondolike.dto.GenderResponse;
import com.example.momondolike.dto.NationalityResponse;
import com.example.momondolike.dto.CombinedResponse;
import com.example.momondolike.entity.CombinedResponseEntity;
import com.example.momondolike.repository.NameDetailRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NameDetailService {

    NameDetailRepo nameDetailRepo;

    public NameDetailService(NameDetailRepo nameDetailRepo) {
        this.nameDetailRepo = nameDetailRepo;
    }


    public CombinedResponseEntity getNameDetails(String name) {
        CombinedResponseEntity combinedResponseEntity = null;

        if (nameDetailRepo.existsByName(name)) {
            combinedResponseEntity = Mono.just(nameDetailRepo.findByName(name)).block();
            combinedResponseEntity.setCached(true);
        } else {
            WebClient client = WebClient.create();
            Mono<GenderResponse> gender = client.get()
                    .uri("https://api.genderize.io?name=" + name)
                    .retrieve()
                    .bodyToMono(GenderResponse.class);

            Mono<AgeResponse> age = client.get()
                    .uri("https://api.agify.io?name=" + name)
                    .retrieve()
                    .bodyToMono(AgeResponse.class);

            Mono<NationalityResponse> nationality = client.get()
                    .uri("https://api.nationalize.io?name=" + name)
                    .retrieve()
                    .bodyToMono(NationalityResponse.class);

            CombinedResponse temp = Mono.zip(gender, age, nationality).map(tuple -> new CombinedResponse(tuple.getT1(), tuple.getT2(), tuple.getT3(), false)).block();
            combinedResponseEntity = CombinedResponse.CombinedResponseEntity(temp);
            nameDetailRepo.save(combinedResponseEntity);
        }
        return combinedResponseEntity;
    }
}

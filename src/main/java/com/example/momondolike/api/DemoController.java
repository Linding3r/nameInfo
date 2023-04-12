package com.example.momondolike.api;

import com.example.momondolike.RemoteApiTester;
import com.example.momondolike.dto.CombinedResponse;
import com.example.momondolike.entity.CombinedResponseEntity;
import com.example.momondolike.service.NameDetailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final int SLEEP_TIME = 1000*3;

    NameDetailService nameDetailService;

    public DemoController(NameDetailService nameDetailService) {
        this.nameDetailService = nameDetailService;
    }


    @GetMapping("/random-string-slow")
    public String slowEndpoint() throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
        return RandomStringUtils.randomAlphanumeric(10);
    }

    @GetMapping("/name/{name}")
    public CombinedResponseEntity getNameInfo(@PathVariable String name){
        return nameDetailService.getNameDetails(name);
    }

}

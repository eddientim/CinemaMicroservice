package com.demo.cinemamicroservice.cinemaservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cinema-seats")
public class CinemaSeatController {

    @GetMapping
    public static void cinemaSeatId() {

    }


}

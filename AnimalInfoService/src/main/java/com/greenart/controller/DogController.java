package com.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DogController {
@GetMapping("/dog")
public String getDog(){
    return "/animal/dog";
    }
}

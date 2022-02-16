package com.example.esap3fitness.controller.rest_api.json;

import com.example.esap3fitness.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/json/gym", produces = MediaType.APPLICATION_JSON_VALUE)
public class GymJsonRestController {

    @Autowired
    private GymService gymService;
}

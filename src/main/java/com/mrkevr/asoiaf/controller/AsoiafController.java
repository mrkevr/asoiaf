package com.mrkevr.asoiaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrkevr.asoiaf.object.House;
import com.mrkevr.asoiaf.service.HouseService;

@RestController
@RequestMapping("/asoiaf")
public class AsoiafController {

	@Autowired
	HouseService houseService;

	@GetMapping("/houses/{name}")
	public ResponseEntity<House> responseHouse(@PathVariable String name) {

		House house = houseService.findHouse(name);

		if (house == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(house);
	}
}

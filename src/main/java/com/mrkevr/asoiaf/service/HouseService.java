package com.mrkevr.asoiaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mrkevr.asoiaf.object.House;

@Service
@PropertySource("housewords.properties")
public class HouseService {
	
	@Autowired
	Environment env;
	
	public House findHouse(String name) {
		
		String key = "house."+name+".words";
		
		if(env.containsProperty(key)) {
			House house = new House();
			house.setName(name.toUpperCase());
			house.setWords(env.getProperty(key));
			return house;
		}
		return null;
	}

}

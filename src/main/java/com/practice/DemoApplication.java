package com.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.practice.DTO.DirectorDTO;
import com.practice.DTO.MovieDTO;
import com.practice.Service.MovieService;

@SpringBootApplication
public class DemoApplication {


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(DemoApplication.class, args);
		MovieService service = (MovieService)context.getBean("movieservice");
		//Insert 
		MovieDTO dto = new MovieDTO("BNC",LocalDate.now(),LocalDateTime.now());
		List<DirectorDTO> directorList = Arrays.asList(
				new DirectorDTO("rst", "hgr", "West Bengal","rst@outlook.com",9007567890L),
				new DirectorDTO("xyz","wyz","Mysore","john@infosys.com",9412340645L)
				);
        service.searchBasedOnTitle("ABC");
        //Get all names of Director from movie title
        System.out.println("GET ALL DIRECTORS FROM MOVIE TITLE");
        service.getDirectorListFromTitle("ABC");
        //Get all Movies from Director Name
        System.out.println("GET ALL MOVIES FROM DIRECTOR NAME");
        service.getMovieListFromDirectorName("xyz");
        //Get All movies
        System.out.println(service.displayAll().toString());       
	}

}

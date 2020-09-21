package com.littlepay.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.littlepay.main.logiclayer.ProcessTrip;
import com.littlepay.main.service.ReadInputFile;

/**
 * 
 * The main class calls the two other classes, one is ReadInputFile and another
 * one is ProcessTrip. ReadInput file is being used to read Tap data from csv
 * and ProcessTrip is being used to process the trips.
 * 
 * @author Sadia Sharmin
 * @version 1.0
 * 
 */

@SpringBootApplication
public class PaymentTransitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentTransitApplication.class, args);

		ReadInputFile readFromFile = new ReadInputFile();
		readFromFile.readTapData();

		ProcessTrip processTrip = new ProcessTrip();
		processTrip.writeToOutput();

	}

}

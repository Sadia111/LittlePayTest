package com.littlepay.main.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.littlepay.main.model.Tap;

/**
 * 
 * The ReadInputFile class is used to read the csv file.
 * 
 * @author Sadia Sharmin
 * @version 1.0
 * 
 */

public class ReadInputFile {

	String line = "";

	public List<Tap> readTapData() {

		List<Tap> list = new ArrayList<Tap>();
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/taps_input.csv"));
			while ((line = br.readLine()) != null) {
				if (count == 0) {
					count++;
					continue;
				}
				String[] data = line.split(",");
				Tap tap = new Tap(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim(),
						data[5].trim(), data[6].trim());

				list.add(tap);

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return list;
	}
}

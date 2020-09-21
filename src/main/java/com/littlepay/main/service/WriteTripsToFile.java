package com.littlepay.main.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.littlepay.main.model.Trip;

/**
 * 
 * The WriteTripsToFile class is used to write the output in the output csv file
 * for each trip.
 * 
 * @author Sadia Sharmin
 * @version 1.0
 * 
 */

public class WriteTripsToFile {

	String line = ",";

	public boolean WriteData(List<Trip> trips) {
		try {

			final BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/trips_output.csv"));

			StringBuffer header = new StringBuffer(
					"Started, Finished, DurationSecs, FromStopId, ToStopId, ChargeAmount, CompanyId, BusID, PAN, Status");
			bw.write(header.toString());
			bw.newLine();

			for (final Trip trip : trips) {
				final StringBuffer oneLine = new StringBuffer();
				oneLine.append(trip.getStartTime() + line);
				oneLine.append(trip.getEndTime() + line);
				oneLine.append(trip.getDurationSecs() + line);
				oneLine.append(trip.getFromStopId() + line);
				oneLine.append(trip.getToStopId() + line);
				oneLine.append(trip.getChargeAmount() + line);
				oneLine.append(trip.getCompanyId() + line);
				oneLine.append(trip.getBusId() + line);
				oneLine.append(trip.getPAN() + line);
				oneLine.append(trip.getStatus() + line);

				bw.write(oneLine.toString());
				bw.newLine();

			}
			bw.flush();
			bw.close();

		} catch (final IOException e) {
			return false;
		}

		return true;
	}

}

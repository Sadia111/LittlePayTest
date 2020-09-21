package com.littlepay.main.logiclayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.littlepay.main.model.Tap;
import com.littlepay.main.model.Trip;
import com.littlepay.main.service.ReadInputFile;
import com.littlepay.main.service.WriteTripsToFile;

/**
 * 
 * The Process Trip class is being used to process the transit for each user
 * specified by PAN.
 * 
 * @author Sadia Sharmin
 * @version 1.0
 * 
 */

public class ProcessTrip {

	ReadInputFile readInputFile = new ReadInputFile();

	public void writeToOutput() {

		List<Tap> taps = readInputFile.readTapData();

		List<String> distPan = new ArrayList<String>();
		distPan = taps.stream().map(x -> x.getPAN()).distinct().collect(Collectors.toList());
		List<Trip> trips = new ArrayList<Trip>();

		for (Tap tap : readInputFile.readTapData()) {

			if (tap.getTapType().equals("ON")) {

				Trip trip = new Trip(tap.getDateTimeUTC(), "", 0L, tap.getStopId(), "", "", tap.getCompanyId(),
						tap.getBusId(), tap.getPAN(), "");

				for (Tap tapOff : readInputFile.readTapData()) {

					if (tapOff.getPAN().equals(tap.getPAN()) && tapOff.getBusId().equals(tap.getBusId())
							&& tapOff.getCompanyId().equals(tap.getCompanyId()) && tapOff.getTapType().equals("OFF")
							&& tapOff.getDate().equals(tap.getDate())
							&& tapOff.getDateTimeUTCDate().compareTo(tap.getDateTimeUTCDate()) > 0) {

						trip.setEndTime(tapOff.getDateTimeUTC());
						trip.setDurationSecs(
								(tapOff.getDateTimeUTCDate().getTime() - tap.getDateTimeUTCDate().getTime() / 1000));
						trip.setToStopId(tapOff.getStopId());

						if (tapOff.getStopId().equals(tap.getStopId())) {
							trip.setStatus("CANCELLED");
						}

						else {
							trip.setStatus("COMPLETE");
						}

						trips.add(trip);
						System.out.println(trip);

					}

				}
				if (!trip.getStatus().equals("CANCELLED") && !trip.getStatus().equals("COMPLETE")) {

					trip.setStatus("INCOMPLETE");
					trips.add(trip);
					System.out.println(trip);

				}

			}

		}

		WriteTripsToFile toFile = new WriteTripsToFile();
		toFile.WriteData(trips);
	}

}

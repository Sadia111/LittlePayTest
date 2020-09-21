package com.littlepay.main.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * The Tap class is being used to handle the taps (on/off).
 * 
 * @author Sadia Sharmin
 * @version 1.0
 * 
 */

public class Tap {

	private String Id;
	private String DateTimeUTC;
	private String TapType;
	private String StopId;
	private String CompanyId;
	private String BusId;
	private String PAN;

	public Tap(String id, String dateTimeUTC, String tapType, String stopId, String companyId, String busId,
			String pAN) {
		super();
		Id = id;
		DateTimeUTC = dateTimeUTC;
		TapType = tapType;
		StopId = stopId;
		CompanyId = companyId;
		BusId = busId;
		PAN = pAN;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDateTimeUTC() {
		return DateTimeUTC;
	}

	public void setDateTimeUTC(String dateTimeUTC) {
		DateTimeUTC = dateTimeUTC;
	}

	public String getTapType() {
		return TapType;
	}

	public void setTapType(String tapType) {
		TapType = tapType;
	}

	public String getStopId() {
		return StopId;
	}

	public void setStopId(String stopId) {
		StopId = stopId;
	}

	public String getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}

	public String getBusId() {
		return BusId;
	}

	public void setBusId(String busId) {
		BusId = busId;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	@Override
	public String toString() {
		return "InputCSV [Id=" + Id + ", DateTimeUTC=" + DateTimeUTC + ", TapType=" + TapType + ", StopId=" + StopId
				+ ", CompanyId=" + CompanyId + ", BusId=" + BusId + ", PAN=" + PAN + ", getId()=" + getId()
				+ ", getDateTimeUTC()=" + getDateTimeUTC() + ", getTapType()=" + getTapType() + ", getStopId()="
				+ getStopId() + ", getCompanyId()=" + getCompanyId() + ", getBusId()=" + getBusId() + ", getPAN()="
				+ getPAN() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public String getDate() {
		try {
			SimpleDateFormat formatterShort = new SimpleDateFormat("dd-MM-YY");

			SimpleDateFormat formatterLong = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);
			Date dt = (Date) formatterLong.parse(this.DateTimeUTC);

			return formatterShort.format(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public Date getDateTimeUTCDate() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.ENGLISH);
		try {
			return (Date) formatter.parse(this.DateTimeUTC);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}

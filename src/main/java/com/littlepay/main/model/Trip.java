package com.littlepay.main.model;

/**
 * 
 * The Trip class holds information about trip depending on the taps.
 * 
 * @author Sadia Sharmin
 * @version 1.0
 * 
 */

public class Trip {

	private String StartTime;
	private String EndTime;
	private Long DurationSecs;
	private String FromStopId;
	private String ToStopId;
	private String ChargeAmount;
	private String CompanyId;
	private String BusId;
	private String PAN;
	private String Status;

	public Trip(String startTime, String endTime, Long durationSecs, String fromStopId, String toStopId,
			String chargeAmount, String companyId, String busId, String pAN, String status) {
		super();
		StartTime = startTime;
		EndTime = endTime;
		DurationSecs = durationSecs;
		FromStopId = fromStopId;
		ToStopId = toStopId;
		ChargeAmount = chargeAmount;
		CompanyId = companyId;
		BusId = busId;
		PAN = pAN;
		Status = status;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public Long getDurationSecs() {
		return DurationSecs;
	}

	public void setDurationSecs(long l) {
		DurationSecs = l;
	}

	public String getFromStopId() {
		return FromStopId;
	}

	public void setFromStopId(String fromStopId) {
		FromStopId = fromStopId;
	}

	public String getToStopId() {
		return ToStopId;
	}

	public void setToStopId(String toStopId) {
		ToStopId = toStopId;
	}

	public String getChargeAmount() {

		if (this.Status.equals("COMPLETE")) {
			switch (this.FromStopId) {

			case "Stop1":

				if (this.ToStopId.equals("Stop2")) {
					return "$3.25";

				}
				if (this.ToStopId.equals("Stop3")) {
					return "$7.30";

				}
				break;

			case "Stop2":

				if (this.ToStopId.equals("Stop1")) {
					return "$3.25";

				}
				if (this.ToStopId.equals("Stop3")) {
					return "$5.50";

				}
				break;

			case "Stop3":

				if (this.ToStopId.equals("Stop1")) {
					return "$7.30";

				}
				if (this.ToStopId.equals("Stop2")) {
					return "$5.50";
				}
				break;
			}

		}

		if (this.Status.equals("INCOMPLETE")) {
			switch (this.FromStopId) {

			case "Stop1":
			case "Stop3":
				return "$7.30";
			case "Stop2":
				return "$5.50";
			}

		}

		return "$0.0";
	}

	public void setChargeAmount(String chargeAmount) {
		ChargeAmount = chargeAmount;
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

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Trip [StartTime=" + StartTime + ", EndTime=" + EndTime + ", DurationSecs=" + DurationSecs
				+ ", FromStopId=" + FromStopId + ", ToStopId=" + ToStopId + ", ChargeAmount=" + ChargeAmount
				+ ", CompanyId=" + CompanyId + ", BusId=" + BusId + ", PAN=" + PAN + ", Status=" + Status + "]";
	}

}

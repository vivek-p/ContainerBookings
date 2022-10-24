package com.maersk.ContainerBookings.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class AvailablilityModel {
	
	private Integer availableSpace;
	private Boolean available;
	private String bookingRef;
	public Integer getAvailableSpace() {
		return availableSpace;
	}
	public void setAvailableSpace(Integer availableSpace) {
		this.availableSpace = availableSpace;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public String getBookingRef() {
		return bookingRef;
	}
	public void setBookingRef(String bookingRef) {
		this.bookingRef = bookingRef;
	}

}

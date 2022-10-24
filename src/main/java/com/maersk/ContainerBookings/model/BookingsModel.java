package com.maersk.ContainerBookings.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class BookingsModel {
	
	private Integer containerSize;
	private ContainerType containerType;
	private String origin;
	private String destination;
	private Integer quantity;
	private String timestamp;
	public Integer getContainerSize() {
		return containerSize;
	}
	public void setContainerSize(Integer containerSize) {
		this.containerSize = containerSize;
	}
	public ContainerType getContainerType() {
		return containerType;
	}
	public void setContainerType(ContainerType containerType) {
		this.containerType = containerType;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}

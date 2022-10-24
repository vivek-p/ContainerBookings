package com.maersk.ContainerBookings.model;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;
import javax.persistence.*;


@Table(value = "bookings")
public class BookingsEntity {

	public BookingsEntity(Integer containerSize, ContainerType containerType, String origin,
			String destination, Integer quantity, String timestamp) {
		this.containerSize = containerSize;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "container_size")
	private Integer containerSize;
	
	@Column(name = "container_type")
	private ContainerType containerType;
	
	@Column(name = "origin", length = 5)
	@Size(min = 3, max =5)
	private String origin;
	
	@Column(name = "destination", length = 5)
	@Size(min = 3, max =5)
	private String destination;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "timestamp")
	private String timestamp;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

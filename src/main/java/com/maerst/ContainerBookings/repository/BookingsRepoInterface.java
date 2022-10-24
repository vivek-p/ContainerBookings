package com.maerst.ContainerBookings.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.maersk.ContainerBookings.model.BookingsEntity;

import reactor.core.publisher.Flux;

public interface BookingsRepoInterface extends ReactiveCassandraRepository<BookingsEntity, Integer> {
	
	@AllowFiltering
	Flux<BookingsEntity> filterById(Integer id);

	@Query(value = "SELECT coalesce(max(id), 0) FROM bookings")
	Integer getMaxId();
}

package com.maersk.ContainerBookings.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.maersk.ContainerBookings.model.AvailablilityModel;
import com.maersk.ContainerBookings.model.BookingsEntity;
import com.maersk.ContainerBookings.model.BookingsModel;
import com.maerst.ContainerBookings.repository.BookingsRepoInterface;

import reactor.core.publisher.Mono;

@Service
public class BookingsService {
	
	@Value("${container.check.api.endpoint}")
	private String containerCheckApiEndpoint;
	
	
	@Autowired
	private BookingsRepoInterface bookingsRepo;
	
	private static final Logger logger = LogManager.getLogger(BookingsService.class);

	public AvailablilityModel checkAvailability(BookingsModel inputData) throws Exception {
		AvailablilityModel response = new AvailablilityModel();
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<AvailablilityModel> result = restTemplate.postForEntity(containerCheckApiEndpoint, inputData, AvailablilityModel.class);
			if(result.getStatusCodeValue() == 200) {
				String available = String.valueOf(result.getBody().getAvailableSpace());
				if(StringUtils.hasLength(available)) {
					if(Integer.valueOf(available) > 0) {
						response.setAvailable(true);
					} else {
						response.setAvailable(false);
					}
				} else {
					throw new Exception("Sorry there was a problem processing your request");
				}
			} else {
				throw new Exception("Sorry there was a problem processing your request");
			}
		} catch (Exception e) {
			throw new Exception("Sorry there was a problem processing your request");
		}
		return response;
	}
	
	public AvailablilityModel saveContainerInfo(BookingsModel inputData) throws Exception {
		AvailablilityModel response = null;
		String staticBookingRefStart = "957000000";
		Integer idIncrement;
		if(!ObjectUtils.isEmpty(inputData)) {
			BookingsEntity entity = new BookingsEntity(inputData.getContainerSize(), inputData.getContainerType(), 
					inputData.getOrigin(), inputData.getDestination(), inputData.getQuantity(), inputData.getTimestamp());
			Mono<BookingsEntity> save = bookingsRepo.save(entity);
			BookingsEntity saved = save.block();
			Integer savedEntityId = saved.getId();
			idIncrement = Integer.valueOf(staticBookingRefStart) + savedEntityId;
			response = new AvailablilityModel();
			response.setBookingRef(String.valueOf(idIncrement));
		} else {
			throw new Exception("Sorry there was a problem processing your request");
		}
		return response;
	}
}

package com.carbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carbooking.model.DealerDto;
import com.carbooking.model.LocationDto;
import com.carbooking.repo.Dealer;
import com.carbooking.repo.DealerRepository;
import com.carbooking.repo.Location;
import com.carbooking.repo.LocationRepository;

@Service
public class DealerService {

    @Autowired
    private DealerRepository dealerRepository;
    
    @Autowired
    private LocationRepository locationRepository;


    public Dealer getDealer(String dealerId) {
        return dealerRepository.findById(dealerId).get();
    }

    @Transactional
    public void updateDealer(DealerDto dealerDto) {
		Dealer dealer = getDealer(dealerDto);
		dealerRepository.save(dealer);
		List<LocationDto> dealerLocations = dealerDto.getOutletLocationDto();
		for (LocationDto locationDto : dealerLocations) {
			Location location = getLocation(locationDto);
			locationRepository.save(location);
		}
	}
    
private Location getLocation(LocationDto dto) {
		Location location = new Location();
		location.setCarRegistrationNo(dto.getCarId());
		location.setCity(dto.getCity());
		location.setCountry(dto.getCountry());
		location.setCustomerId(dto.getCustomerId());
		location.setDealerId(dto.getDealerId());
		location.setFlatNo(dto.getFlatNo());
		location.setPinCode(dto.getPinCode());
		location.setStreet(dto.getStreet());
		
		return location;
	}


	private Dealer getDealer(DealerDto dealerDto) {
		Dealer dealer = new Dealer();
		dealer.setContactNo(dealerDto.getContactNo());
		dealer.setDealerId(dealerDto.getDealerId());
		dealer.setEmailAddress(dealerDto.getEmailAddress());
		dealer.setName(dealerDto.getName());
		
		return dealer;
	}
}

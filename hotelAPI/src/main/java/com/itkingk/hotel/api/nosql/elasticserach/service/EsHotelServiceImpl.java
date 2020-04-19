package com.itkingk.hotel.api.nosql.elasticserach.service;

import com.itkingk.hotel.api.mbg.model.Hotel;
import com.itkingk.hotel.api.nosql.elasticserach.EsHotelRepository;
import com.itkingk.hotel.api.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kingk
 * @date 2020/4/19 11:23
 */
@Service
public class EsHotelServiceImpl implements EsHotelService {

	private HotelService hotelService;
	private EsHotelRepository repository;

	@Autowired
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@Autowired
	public void setRepository(EsHotelRepository repository) {
		this.repository = repository;
	}

	@Override
	public int importAll() {
		List<Hotel> allHotel = hotelService.getAll();
		Iterable<Hotel> hotels = repository.saveAll(allHotel);
		int result = 0;
		for (Hotel hotel : hotels) {
			result++;
		}
		return result;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Hotel create(Long id) {
		Hotel hotel = hotelService.getHotelById(id);
		if (hotel != null) {
			return repository.save(hotel);
		}
		return null;
	}

	@Override
	public void deletes(List<Long> ids) {
		if (!CollectionUtils.isEmpty(ids)) {
			List<Hotel> hotels = new ArrayList<>(ids.size());
			for (Long id : ids) {
				Hotel hotel = new Hotel();
				hotel.setHotelId(id);
				hotels.add(hotel);
			}
			repository.deleteAll(hotels);
		}
	}

	@Override
	public Page<Hotel> search(String name, Integer pageNum, Integer pageSize) {
		return repository.findByName(name, PageRequest.of(pageNum, pageSize));
	}
}

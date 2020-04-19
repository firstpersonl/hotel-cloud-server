package com.itkingk.hotel.api.nosql.elasticserach.service;

import com.itkingk.hotel.api.mbg.model.EsHotel;
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
		List<Hotel> hotels = hotelService.getAll();
		if (!CollectionUtils.isEmpty(hotels)) {
			List<EsHotel> esHotels = new ArrayList<>(hotels.size());
			for (Hotel hotel : hotels) {
				EsHotel esHotel = new EsHotel();
				esHotel.setHotelId(hotel.getHotelId());
				esHotel.setAddress(hotel.getAddress());
				esHotel.setName(hotel.getName());
				esHotels.add(esHotel);
			}
			repository.saveAll(esHotels);
			return esHotels.size();
		}
		return 0;
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public EsHotel create(Long id) {
		Hotel hotel = hotelService.getHotelById(id);
		if (hotel != null) {
			EsHotel esHotel = new EsHotel();
			esHotel.setHotelId(hotel.getHotelId());
			esHotel.setAddress(hotel.getAddress());
			esHotel.setName(hotel.getName());
			return repository.save(esHotel);
		}
		return null;
	}

	@Override
	public void deletes(List<Long> ids) {
		if (!CollectionUtils.isEmpty(ids)) {
			List<EsHotel> esHotels = new ArrayList<>(ids.size());
			for (Long id : ids) {
				EsHotel esHotel = new EsHotel();
				esHotel.setHotelId(id);
				esHotels.add(esHotel);
			}
			repository.deleteAll(esHotels);
		}
	}

	@Override
	public Page<EsHotel> search(String name, Integer pageNum, Integer pageSize) {
		return repository.findByName(name, PageRequest.of(pageNum, pageSize));
	}
}

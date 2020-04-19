package com.itkingk.hotel.api.service.impl;

import com.itkingk.hotel.api.mbg.mapper.HotelMapper;
import com.itkingk.hotel.api.mbg.model.Hotel;
import com.itkingk.hotel.api.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kingk
 * @date 2020/4/19 0:32
 */
@Service
public class HotelServiceImpl implements HotelService {

	private HotelMapper hotelMapper;

	@Autowired
	public void setHotelMapper(HotelMapper hotelMapper) {
		this.hotelMapper = hotelMapper;
	}

	@Override
	public Hotel getHotelById(Long hotelId) {
		return hotelMapper.selectByPrimaryKey(hotelId);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelMapper.selectByExample(null);
	}
}

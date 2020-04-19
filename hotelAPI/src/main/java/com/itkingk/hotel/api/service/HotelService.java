package com.itkingk.hotel.api.service;

import com.itkingk.hotel.api.mbg.model.Hotel;

import java.util.List;

/**
 * @author kingk
 * @date 2020/4/19 0:29
 */
public interface HotelService {

	/**
	 * 根据酒店ID获取信息
	 * @param hotelId hotel.id
	 * @return
	 */
	Hotel getHotelById(Long hotelId);

	/**
	 * 查询所有酒店
	 * @return
	 */
	List<Hotel> getAll();

}

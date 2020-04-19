package com.itkingk.hotel.api.controller;

import com.itkingk.hotel.api.mbg.model.EsHotel;
import com.itkingk.hotel.api.mbg.model.Hotel;
import com.itkingk.hotel.api.nosql.elasticserach.service.EsHotelService;
import com.itkingk.hotel.api.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author kingk
 * @date 2020/4/18 19:33
 */
@RestController
@RequestMapping(value = "api/v1/hotel")
public class HotelController {

	private HotelService hotelService;
	private EsHotelService esHotelService;
	@Autowired
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@Autowired
	public void setEsHotelService(EsHotelService esHotelService) {
		this.esHotelService = esHotelService;
	}

	@GetMapping(value = "get/{hotelId}")
	public Hotel getHotelById(@PathVariable Long hotelId) {
		return hotelService.getHotelById(hotelId);
	}

	@GetMapping(value = "importAllToEs")
	public ResponseEntity<Integer> importAllToEs() {
		int count = esHotelService.importAll();
		return ResponseEntity.ok(count);
	}

	@GetMapping(value = "search")
	public ResponseEntity<Page<EsHotel>> searchHotel(@RequestParam String keyword, Pageable pageable) {
		Page<EsHotel> search = esHotelService.search(keyword, pageable.getPageNumber(), pageable.getPageSize());
		return ResponseEntity.ok(search);
	}
}

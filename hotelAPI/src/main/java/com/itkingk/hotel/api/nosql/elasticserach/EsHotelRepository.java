package com.itkingk.hotel.api.nosql.elasticserach;

import com.itkingk.hotel.api.mbg.model.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author kingk
 * @date 2020/4/19 11:00
 */

public interface EsHotelRepository extends ElasticsearchRepository<Hotel, Long> {
	/**
	 * 分页查询
	 * @param name 商品名称
	 * @param pageable 分页信息
	 * @return
	 */
	Page<Hotel> findByName(String name, Pageable pageable);
}

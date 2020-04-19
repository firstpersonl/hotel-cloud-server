package com.itkingk.hotel.api.nosql.elasticserach.service;

import com.itkingk.hotel.api.mbg.model.EsHotel;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 酒店es搜索管理service
 * @author kingk
 * @date 2020/4/19 11:17
 */
public interface EsHotelService {
	/**
	 * 从数据库导入所有酒店信息
	 * @return
	 */
	int importAll();

	/**
	 * 删除指定id的酒店信息
	 * @param id 酒店ID
	 */
	void delete(Long id);

	/**
	 * 创建酒店es信息
	 * @param id 酒店ID
	 * @return
	 */
	EsHotel create(Long id);

	/**
	 * 批量删除
	 * @param ids 酒店id列表
	 */
	void deletes(List<Long> ids);

	/**
	 * 根据酒店名称搜索
	 * @param name 名称关键字
	 * @param pageNum 页码
	 * @param pageSize 分页大小
	 * @return
	 */
	Page<EsHotel> search(String name, Integer pageNum, Integer pageSize);
}

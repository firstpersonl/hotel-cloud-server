package com.itkingk.hotel.api.mbg.mapper;

import com.itkingk.hotel.api.mbg.model.Hotel;
import com.itkingk.hotel.api.mbg.model.HotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelMapper {
    long countByExample(HotelExample example);

    int deleteByExample(HotelExample example);

    int deleteByPrimaryKey(Long hotelId);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    List<Hotel> selectByExample(HotelExample example);

    Hotel selectByPrimaryKey(Long hotelId);

    int updateByExampleSelective(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByExample(@Param("record") Hotel record, @Param("example") HotelExample example);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);
}
package com.itkingk.hotel.api.mbg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * hotel DTO 对象
 * @author kingk
 */
@Document(indexName = "hotel", type = "hotel", shards = 1, replicas = 0)
public class EsHotel implements Serializable {
    @Id
    @Field(type = FieldType.Long)
    private Long hotelId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;
    private String address;

    private static final long serialVersionUID = 1L;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hotelId=").append(hotelId);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
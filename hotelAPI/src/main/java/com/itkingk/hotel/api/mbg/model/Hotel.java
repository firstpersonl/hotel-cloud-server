package com.itkingk.hotel.api.mbg.model;

import org.postgresql.geometric.PGpoint;

import java.io.Serializable;

public class Hotel implements Serializable {
    private Long hotelId;

    private String name;

    private String address;

    /**
     * 移动电话
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 固定电话
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     * 经纬度
     *
     * @mbg.generated
     */
    private PGpoint point;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public PGpoint getPoint() {
        return point;
    }

    public void setPoint(PGpoint point) {
        this.point = point;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        sb.append(", phone=").append(phone);
        sb.append(", telephone=").append(telephone);
        sb.append(", point=").append(point);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author Atif Hassan
 */
public class Hospital implements Comparable<Hospital>, Serializable {

    private String Name;
    private String Address;
    private String City;
    private String State;
    private String ZipCode;
    private String Latitude;
    private String Longitude;
    private String Phone;
    private String Image;

    /**
     *
     */
    public Hospital() {
        this.Name = "";
        this.Address = "";
        this.City = "";
        this.State = "";
        this.ZipCode = "";
        this.Latitude = "";
        this.Longitude = "";
        this.Phone = "";
        this.Image = "";
    }

    /**
     *
     * @param Name
     * @param Address
     * @param City
     * @param State
     * @param ZipCode
     * @param Latitude
     * @param Longitude
     * @param Phone
     * @param Image
     */
    public Hospital(String Name, String Address, String City, String State, String ZipCode, String Latitude, String Longitude, String Phone, String Image) {
        this.Name = Name;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.ZipCode = ZipCode;
        this.Latitude = Latitude;
        this.Longitude = Longitude;
        this.Phone = Phone;
        this.Image = Image;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @param Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return Address;
    }

    /**
     *
     * @param Address
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @param City
     */
    public void setCity(String City) {
        this.City = City;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return State;
    }

    /**
     *
     * @param State
     */
    public void setState(String State) {
        this.State = State;
    }

    /**
     *
     * @return
     */
    public String getZipCode() {
        return ZipCode;
    }

    /**
     *
     * @param ZipCode
     */
    public void setZipCode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    /**
     *
     * @return
     */
    public String getLatitude() {
        return Latitude;
    }

    /**
     *
     * @param Latitude
     */
    public void setLatitude(String Latitude) {
        this.Latitude = Latitude;
    }

    /**
     *
     * @return
     */
    public String getLongitude() {
        return Longitude;
    }

    /**
     *
     * @param Longitude
     */
    public void setLongitude(String Longitude) {
        this.Longitude = Longitude;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return Phone;
    }

    /**
     *
     * @param Phone
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     *
     * @return
     */
    public String getImage() {
        return Image;
    }

    /**
     *
     * @param Image
     */
    public void setImage(String Image) {
        this.Image = Image;
    }

    @Override
    public String toString() {
        return "Hospital{" + "Name=" + Name + ", Address=" + Address + ", City=" + City + ", State=" + State + ", ZipCode=" + ZipCode + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Phone=" + Phone + ", Image=" + Image + '}';
    }

    @Override
    public int compareTo(Hospital o) {
        return ZipCode.compareTo(o.getZipCode());
    }

}

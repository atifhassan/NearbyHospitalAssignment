/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Objects;

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
    private Double Latitude;
    private Double Longitude;
    private String Phone;
    private String Image;
    private double Distance;
    private static int compareInt;


    /**
     *
     */
    public Hospital() {
        this.Name = "";
        this.Address = "";
        this.City = "";
        this.State = "";
        this.ZipCode = "";
        this.Latitude = 0.0;
        this.Longitude = 0.0;
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
        this.Latitude = Double.parseDouble(Latitude);
        this.Longitude = Double.parseDouble(Longitude);
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
    public Double getLatitude() {
        return Latitude;
    }

    /**
     *
     * @param Latitude
     */
    public void setLatitude(String Latitude) {
        this.Latitude = Double.parseDouble(Latitude);
    }

    /**
     *
     * @return
     */
    public Double getLongitude() {
        return Longitude;
    }

    /**
     *
     * @param Longitude
     */
    public void setLongitude(String Longitude) {
        this.Longitude = Double.parseDouble(Longitude);
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

    /**
     *
     * @return
     */
    public double getDistance() {
        return Distance;
    }

    /**
     *
     * @param lat
     * @param lon
     */
    public void setDistance(double lat, double lon) {
        this.Distance = Haversine.getDistance(lat, lon,Latitude, Longitude);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Hospital{" + "Name=" + Name + ", Address=" + Address + ", City=" + City + ", State=" + State + ", ZipCode=" + ZipCode + ", Latitude=" + Latitude + ", Longitude=" + Longitude + ", Phone=" + Phone + ", Image=" + Image + ", distance=" + Distance + '}';
    }

    public static int getCompareInt() {
        return compareInt;
    }

    public static void setCompareInt(int compareInt) {
        Hospital.compareInt = compareInt;
    }

     @Override
    public int compareTo(Hospital o) {
        switch (compareInt) {
            case 1:
                if (this.ZipCode.length() < o.getZipCode().length()) {
                    return this.ZipCode.compareToIgnoreCase(o.getZipCode().substring(0, this.ZipCode.length()));
                }else if (this.ZipCode.length() >= o.getZipCode().length()){
                    return this.ZipCode.compareToIgnoreCase(o.getZipCode());}
                break;
            case 2:
                if (this.Name.length() < o.getName().length()) {
                    return this.Name.compareToIgnoreCase(o.getName().substring(0, this.Name.length()));
                }else if (this.Name.length() >= o.getName().length()){
                    return this.Name.compareToIgnoreCase(o.getName());}
                break;
            case 3:
                if (this.City.length() < o.getCity().length()) {
                    return this.City.compareToIgnoreCase(o.getCity().substring(0, this.City.length()));
                }else if (this.City.length() >= o.getCity().length()){
                    return this.City.compareToIgnoreCase(o.getCity());}
                break;
            case 4:
                if (this.Phone.length() < o.getPhone().length()) {
                    return this.Phone.compareToIgnoreCase(o.getPhone().substring(0, this.Phone.length()));
                }else if (this.Phone.length() >= o.getPhone().length()){
                    return this.Phone.compareToIgnoreCase(o.getPhone());}
                break;
            case 5:
                if (this.Latitude.compareTo(o.getLatitude()) != 0){
                    return this.Latitude.compareTo(o.getLatitude());
                }else{
                    return this.Longitude.compareTo(o.getLongitude());
                }
            case 6:
                if (this.Distance <= o.getDistance()){
                    return -1;
                } else if (this.Distance > o.getDistance()){
                    return 1;}
                break;
            case 7:
                if (this.Distance < o.getDistance()){
                    return 1;
                }else if(this.Distance == o.getDistance()){
                    return 0;
                } else if (this.Distance > o.getDistance()){
                    return -1;
                }   break;
            default:
                break;
        }
        return 0;
     }
    /**
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Hospital)) {
            return false;
        }
        Hospital o = (Hospital) other;
        return this.Name.equals(o.getName());
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Name);
        hash = 53 * hash + Objects.hashCode(this.Address);
        hash = 53 * hash + Objects.hashCode(this.City);
        hash = 53 * hash + Objects.hashCode(this.State);
        hash = 53 * hash + Objects.hashCode(this.ZipCode);
        hash = 53 * hash + Objects.hashCode(this.Latitude);
        hash = 53 * hash + Objects.hashCode(this.Longitude);
        hash = 53 * hash + Objects.hashCode(this.Phone);
        hash = 53 * hash + Objects.hashCode(this.Image);
        return hash;
    }
}

package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "ship_detail")

public class ShipDetail {
    @Id
    private int shipId;
    private  String name;
    private String source;
    private String destination;
    private int capacity;
    private int cruiseLength;
    private String cruiseType;
    private Date date;
    private float price;
    private float rating;
    private int availability;

    public ShipDetail(){

    }

    public ShipDetail(int shipId, String name, String source, String destination, int capacity, int cruiseLength, String cruiseType, Date date, float price, float rating, int availability) {
        this.shipId = shipId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.cruiseLength = cruiseLength;
        this.cruiseType = cruiseType;
        this.date = date;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getCruiseLength() {
        return cruiseLength;
    }

    public void setCruiseLength(int cruiseLength) {
        this.cruiseLength = cruiseLength;
    }

    public String getCruiseType() {
        return cruiseType;
    }

    public void setCruiseType(String cruiseType) {
        this.cruiseType = cruiseType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int isAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}


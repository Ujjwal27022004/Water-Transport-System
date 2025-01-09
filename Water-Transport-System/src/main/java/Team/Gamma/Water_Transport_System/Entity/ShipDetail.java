package Team.Gamma.Water_Transport_System.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import Team.Gamma.Water_Transport_System.Enum.CruiseType;
import java.util.*;

@Entity
@Table(name = "ship_detail")

public class ShipDetail {
    @Id
    private Long shipId;
    private  String name;
    private String source;
    @JsonProperty("destination")
    private String destination;
    private final int capacity = 200;
    private int cruiseLength;
    @Enumerated(EnumType.STRING)
    @Column(name = "cruiseType")
    private CruiseType cruiseType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private final float price = 1000;
    private float rating;
    private boolean availability;

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
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

    // No setter for capacity to enforce immutability

    public float getCruiseLength() {
        return cruiseLength;
    }

    public void setCruiseLength(int cruiseLength) {
        this.cruiseLength = cruiseLength;
    }

    public CruiseType getCruiseType() {
        return cruiseType;
    }

    public void setCruiseType(CruiseType cruiseType) {
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    //constructor
    public ShipDetail(){

    }
    public ShipDetail(Long shipId, String name, String source, String destination, int cruiseLength, CruiseType cruiseType, Date date, float rating, boolean availability) {
        this.shipId = shipId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.cruiseLength = cruiseLength;
        this.cruiseType = cruiseType;
        this.date = date;
        this.rating = rating;
        this.availability = availability;
    }

}

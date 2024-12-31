package Team.Gamma.Water_Transport_System.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private int capacity = 200;
    private int cruiseLength;
    private String cruiseType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private float price;
    private float rating;
    private boolean availability;

    public ShipDetail(){
        // Default constructor
    }

    public ShipDetail(Long shipId, String name, String source, String destination, int cruiseLength, String cruiseType, Date date, float price, float rating, boolean availability) {
        this.shipId = shipId;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.cruiseLength = cruiseLength;
        this.cruiseType = cruiseType;
        this.date = date;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
    }

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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        if (source == null || source.trim().isEmpty()) {
            throw new IllegalArgumentException("Source cannot be null or empty");
        }
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty");
        }
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
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }
        this.rating = rating;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

package Team.Gamma.Water_Transport_System.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PassengerDetail")
public class PassengerDetails {
    @Id
    private long passengerID;
    private long bookingID;
    private String name;
    private int age;
    private int gender;
    private enum seatPreference{Balcony,Insider,Outsider};

    public long getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(long passengerID) {
        this.passengerID = passengerID;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public PassengerDetails() {
    }
}

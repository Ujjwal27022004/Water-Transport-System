package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PassengerDDetail")
public class PassengerDetails {
    @Id
    private Long passengerId;
    private Long bookingId;
    private String name;
    private int age;
    private String gender;

//    private enum seatPreference{Balcony,Insider,Outsider};

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerID(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingID(long bookingId) {
        this.bookingId = bookingId;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PassengerDetails() {
    }
}

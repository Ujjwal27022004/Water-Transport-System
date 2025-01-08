package Team.Gamma.Water_Transport_System.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PassengerDDetail")
public class PassengerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long passengerId;
    @Column(insertable=false, updatable=false)
    private Long bookingId;
    private String name;
    private int age;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Bookings booking; // Foreign key to Booking entity

    //Getter and setter
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

    //Constructor
    public PassengerDetails() {
    }
}

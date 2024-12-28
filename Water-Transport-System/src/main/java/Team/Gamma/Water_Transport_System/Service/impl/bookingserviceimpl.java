package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Service.Bookingservice;
import org.springframework.stereotype.Service;


@Service
public class bookingserviceimpl implements Bookingservice {

    public bookingserviceimpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    BookingRepository bookingRepository;

    @Override
    public String makebooking(Bookings bookings) {

        bookingRepository.save(bookings);


        return "Your Ticket has been booked successfully!!";
    }

    @Override
    public String cancelbooking(long bookingId) {

        bookingRepository.deleteById(bookingId);

        return "Your Ticket has been cancelled successfully";

    }
}

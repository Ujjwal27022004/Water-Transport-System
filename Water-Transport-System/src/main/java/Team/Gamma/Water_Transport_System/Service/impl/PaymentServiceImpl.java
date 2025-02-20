package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.Payment;
import Team.Gamma.Water_Transport_System.Enum.BookingStatus;
import Team.Gamma.Water_Transport_System.Enum.PaymentMethod;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.PaymentRepository;
import Team.Gamma.Water_Transport_System.Repository.PassengerDetailsRepository;
import Team.Gamma.Water_Transport_System.Dto.PaymentDTO;
import Team.Gamma.Water_Transport_System.Service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {


    private BookingRepository bookingRepository;

    public PaymentServiceImpl(BookingRepository bookingRepository, PaymentRepository paymentRepository, PassengerDetailsRepository passengerDetailsRepository) {
        this.bookingRepository = bookingRepository;
        this.paymentRepository = paymentRepository;
        this.passengerDetailsRepository = passengerDetailsRepository;
    }

    private PaymentRepository paymentRepository;


    private PassengerDetailsRepository passengerDetailsRepository;

    // Function to initiate payment
    public Payment initiatePayment(Long bookingId,double amount) {
        Optional<Bookings> booking = Optional.ofNullable(bookingRepository.findByBookingId(bookingId));

        if (booking.isPresent()) {
            // Create a new Payment with "pending" status
            Bookings bookings = booking.get();
            bookings.setBookingStatus(BookingStatus.BOOKED);
            Payment payment = new Payment();
            payment.setBookingID(bookings.getBookingId());
            payment.setPaymentMethod(PaymentMethod.NETBANKING);
            payment.setAmount(amount);
            payment.setDate(new java.util.Date());
            payment.setPaymentStatus("PENDING");

            paymentRepository.save(payment);

            return payment;
        } else {
            return null;
        }
    }

    // Function to confirm payment
    public PaymentDTO confirmPayment(Long paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);

        if (payment.isPresent() && payment.get().getPaymentStatus() .equals("PENDING") ) {
            // Update payment status to "Success"
            Payment confirmedPayment = payment.get();
            confirmedPayment.setPaymentStatus("SUCCESS");
            paymentRepository.save(confirmedPayment);

            // Update passenger count in the PassengerDetails table
            long passengerCount = passengerDetailsRepository.countByBookingId(confirmedPayment.getBookingID());
            // Assuming the method exists in Booking to update total passengers
            Bookings booking = bookingRepository.findByBookingId(confirmedPayment.getBookingID());
            if (booking != null) {
                booking.setSeatsBooked(booking.getSeatsBooked() + (int) passengerCount);
                bookingRepository.save(booking);
            }

            return new PaymentDTO("Payment is successful.", true);
        } else {
            return new PaymentDTO("Payment not found or already processed.", false);
        }
    }
}

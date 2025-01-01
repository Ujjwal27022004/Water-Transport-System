package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Entity.Bookings;
import Team.Gamma.Water_Transport_System.Entity.Payment;
import Team.Gamma.Water_Transport_System.Entity.Receipt;
import Team.Gamma.Water_Transport_System.Entity.Ship;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.PaymentRepository;
import Team.Gamma.Water_Transport_System.Repository.ReceiptRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipRepository;
import Team.Gamma.Water_Transport_System.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private BookingRepository bookingRepository; // Assuming you have a booking repository to fetch booking info

    @Autowired
    private ShipRepository shipRepository; // Assuming you have a ship repository
    @Autowired
    private PaymentRepository paymentRepository; // Assuming you have a payment repository

    // Method to generate a receipt
    public Receipt generateReceipt(Long userId) {
        // Fetch the booking, ship, and payment details (you may need custom queries)
        Bookings booking = bookingRepository.findByUser_userid(userId);
        // Assuming you have a Booking object
        // Corrected method
        Optional<Ship> shipOptional = shipRepository.findById(booking.getShip().getShipId());
        Ship ship = shipOptional.orElseThrow(() -> new RuntimeException("Ship not found with ID: " + booking.getShip().getShipId()));


        Optional<Payment> paymentOptional = paymentRepository.findById(booking.getPayment().getId());
        Payment payment = paymentOptional.orElseThrow(() -> new RuntimeException("Payment not found with ID: " + booking.getPayment().getId()));

        // Generate the receipt
        Receipt receipt = new Receipt();
        receipt.setPaymentID(payment.getPaymentID());
        receipt.setUserID(userId);
        receipt.setShipID(ship.getShipId());
        receipt.setTransactionType(payment.getPaymentMethod());
        receipt.setAmount(payment.getAmount());
        receipt.setDate(new Date()); // Assuming you want to set the current date

        // Save the receipt to the database
        return receiptRepository.save(receipt);
    }
}

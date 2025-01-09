package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.ReceiptDTO;
import Team.Gamma.Water_Transport_System.Entity.*;
import Team.Gamma.Water_Transport_System.Repository.BookingRepository;
import Team.Gamma.Water_Transport_System.Repository.PaymentRepository;
import Team.Gamma.Water_Transport_System.Repository.ReceiptRepository;
import Team.Gamma.Water_Transport_System.Repository.ShipDetailsRepository;
import Team.Gamma.Water_Transport_System.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
@Service
public class ReceiptServiceImpl {


    private ReceiptRepository receiptRepository;

    private UserImpl userService;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, UserImpl userService, ShipServiceImpl shipService, PaymentServiceImpl paymentService, Bookingserviceimpl bookingserviceimpl) {
        this.receiptRepository = receiptRepository;
        this.userService = userService;
        this.shipService = shipService;
        this.paymentService = paymentService;
        this.bookingserviceimpl = bookingserviceimpl;
    }

    private ShipServiceImpl shipService;

    private PaymentServiceImpl paymentService;

    private Bookingserviceimpl bookingserviceimpl;


    public ReceiptDTO generateReceipt(Long userId) {
        User user = userService.getUserDetails(userId);
        Bookings booking = bookingserviceimpl.getLatestBookingByUserId(userId);

        if (user == null || booking == null) {
            throw new IllegalArgumentException("Invalid data provided");
        }

        ShipDetail ship = booking.getShip();

        Receipt receipt = new Receipt();
        receipt.setUser(user);
        receipt.setShip(ship);
        receipt.setAmount(booking.getTotalPrice());
        receipt.setDate(new Date());
        receipt = receiptRepository.save(receipt);

        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setReceiptId(receipt.getReceiptId());
        receiptDTO.setAmount(receipt.getAmount());
        receiptDTO.setDate(receipt.getDate());
        receiptDTO.setUser(user);
        receiptDTO.setShip(booking.getShip());
        return receiptDTO;


    }
}
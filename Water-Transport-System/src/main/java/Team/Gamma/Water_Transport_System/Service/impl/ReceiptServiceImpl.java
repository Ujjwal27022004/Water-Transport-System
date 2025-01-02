package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.ReceiptDTO;
import Team.Gamma.Water_Transport_System.Dto.UserDTO;
import Team.Gamma.Water_Transport_System.Entity.*;
import Team.Gamma.Water_Transport_System.Repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReceiptServiceImpl {

    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private UserImpl userService;
    @Autowired
    private ShipServiceImpl shipService;
    @Autowired
    private PaymentServiceImpl paymentService;
    @Autowired
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
//package Team.Gamma.Water_Transport_System.Service.impl;
//
//import Team.Gamma.Water_Transport_System.Dto.ReceiptDTO;
//import Team.Gamma.Water_Transport_System.Entity.*;
//import Team.Gamma.Water_Transport_System.Repository.ReceiptRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class ReceiptServiceImpl {
//
//
//    private ReceiptRepository receiptRepository;
//
//    private UserImpl userService;
//
//    public ReceiptServiceImpl(ReceiptRepository receiptRepository, UserImpl userService, ShipServiceImpl shipService, PaymentServiceImpl paymentService, Bookingserviceimpl bookingserviceimpl) {
//        this.receiptRepository = receiptRepository;
//        this.userService = userService;
//        this.shipService = shipService;
//        this.paymentService = paymentService;
//        this.bookingserviceimpl = bookingserviceimpl;
//    }
//
//    private ShipServiceImpl shipService;
//
//    private PaymentServiceImpl paymentService;
//
//    private Bookingserviceimpl bookingserviceimpl;
//
//
//    public ReceiptDTO generateReceipt(Long bookingId) {
//        User user = userService.getUserDetails(bookingId);
//        Bookings booking = bookingserviceimpl.getBookingById(bookingId);
//
//        if (user == null || booking == null) {
//            throw new IllegalArgumentException("Invalid data provided");
//        }
//
//        ShipDetail ship = booking.getShip();
//
//        Receipt receipt = new Receipt();
//        receipt.setUser(user);
//        receipt.setShip(ship);
//        receipt.setAmount(booking.getTotalPrice());
//        receipt.setDate(new Date());
//        receipt = receiptRepository.save(receipt);
//
//        ReceiptDTO receiptDTO = new ReceiptDTO();
//        receiptDTO.setReceiptId(receipt.getReceiptId());
//        receiptDTO.setAmount(receipt.getAmount());
//        receiptDTO.setDate(receipt.getDate());
//        receiptDTO.setUser(user);
//        receiptDTO.setShip(booking.getShip());
//        return receiptDTO;
//
//
//    }
//}
package Team.Gamma.Water_Transport_System.Service.impl;

import Team.Gamma.Water_Transport_System.Dto.ReceiptDTO;
import Team.Gamma.Water_Transport_System.Entity.*;
import Team.Gamma.Water_Transport_System.Repository.ReceiptRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReceiptServiceImpl {

    private ReceiptRepository receiptRepository;
    private UserImpl userService;
    private ShipServiceImpl shipService;
    private PaymentServiceImpl paymentService;
    private Bookingserviceimpl bookingserviceimpl;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, UserImpl userService, ShipServiceImpl shipService, PaymentServiceImpl paymentService, Bookingserviceimpl bookingserviceimpl) {
        this.receiptRepository = receiptRepository;
        this.userService = userService;
        this.shipService = shipService;
        this.paymentService = paymentService;
        this.bookingserviceimpl = bookingserviceimpl;
    }

    public ReceiptDTO generateReceipt(Long bookingId) {
        // Fetch the booking based on the booking ID
        Bookings booking = bookingserviceimpl.getBookingById(bookingId);

        if (booking == null) {
            throw new IllegalArgumentException("Invalid booking ID provided");
        }

        User user = userService.getUserDetails(booking.getUser().getUserId());

        if (user == null) {
            throw new IllegalArgumentException("Invalid user ID provided");
        }

        // Get the ship from the booking
        ShipDetail ship = booking.getShip();

        // Create a new Receipt
        Receipt receipt = new Receipt();
        receipt.setUser(user);
        receipt.setShip(ship);
        receipt.setAmount(booking.getTotalPrice());
        receipt.setDate(new Date());
        receipt = receiptRepository.save(receipt);

        // Create and return a ReceiptDTO with the necessary data
        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setReceiptId(receipt.getReceiptId());
        receiptDTO.setAmount(receipt.getAmount());
        receiptDTO.setDate(receipt.getDate());
        receiptDTO.setUser(user);
        receiptDTO.setShip(ship);

        return receiptDTO;
    }
}

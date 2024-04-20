// package tms.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.PostMapping;

// import tms.demo.model.BookingDetails;
// import tms.demo.repository.BookingDetailsRepository;

// @Controller
// public class BookingDetailsController {

// private final BookingDetailsRepository bookingDetailsRepository;

// @Autowired
// public BookingController(BookingDetailsRepository bookingDetailsRepository) {
// this.bookingDetailsRepository = bookingDetailsRepository;
// }

// @PostMapping("/book-package")
// public String bookPackage(BookingDetails bookingDetails, Model model) {
// // Save booking details to the database
// bookingDetailsRepository.save(bookingDetails);

// // Pass the booking details to the view
// model.addAttribute("bookingDetails", bookingDetails);

// return "booked-package";
// }
// }

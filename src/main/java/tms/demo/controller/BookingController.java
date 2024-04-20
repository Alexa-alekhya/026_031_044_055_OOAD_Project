package tms.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tms.demo.repository.HotelRepository;

@Controller
public class BookingController {

    private final HotelRepository hotelRepository;

    public BookingController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/book-hotel")
    public String bookHotel(Model model) {
        // Fetch all hotels from the repository
        model.addAttribute("hotels", hotelRepository.getAllHotels());
        return "book-hotel";
    }
}
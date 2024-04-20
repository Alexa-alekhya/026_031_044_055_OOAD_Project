package tms.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import tms.demo.repository.PackageRepository;

@Controller
public class PackageController {

    private final PackageRepository PackageRepository;

    public PackageController(PackageRepository PackageRepository) {
        this.PackageRepository = PackageRepository;
    }

    @GetMapping("/book-package")
    public String bookPackage(Model model) {
        // Fetch all booking packages from the repository
        model.addAttribute("packages", PackageRepository.getAllPackages());
        return "book-package";
    }


    @PostMapping("/book-package")
    public String bookPackage() {
        // Any necessary logic for booking package can be added here

        // For simplicity, let's assume the booking is successful and redirect to book
        // hotel
        return "redirect:/book-hotel"; // Redirect to book hotel page
    }
}

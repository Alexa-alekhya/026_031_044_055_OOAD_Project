package tms.demo.controller;


// PaymentController class
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {

    @GetMapping("/payment")
    public String showPaymentPage() {
        return "payment";
    }

    @PostMapping("/processPayment")
    public String processPayment() {
        // Process payment logic
        return "redirect:/"; // Redirect to the home page
    }
}

package tms.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import tms.demo.model.Account;
import tms.demo.repository.AccountRepository;

@Controller
public class LoginController {

    private final AccountRepository accountRepository;

    public LoginController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("account", new Account());
        return "login";
    }

    // @PostMapping("/login")
    // public String login(@ModelAttribute("account") Account account) {
    // if (accountRepository.findByUsernameAndPassword(account.getUsername(),
    // account.getPassword()) != null) {
    // return "redirect:/book-package"; // Redirect to home page after successful
    // login
    // } else {
    // return "redirect:/login?error"; // Redirect back to login page with an error
    // message
    // }
    // }
    @PostMapping("/login")
    public String login(@ModelAttribute("account") Account account) {
        // You can perform any necessary login logic here
        // For simplicity, let's assume the login is always successful
        return "redirect:/combined.html"; // Redirect to combined.html after successful login
    }
}

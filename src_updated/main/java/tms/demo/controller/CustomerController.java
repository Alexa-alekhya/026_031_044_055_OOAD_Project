package tms.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tms.demo.model.Customer;
import tms.demo.repository.CustomerRepository;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    @Autowired
    public CustomerRepository customerRepository;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customer-list";
    }

    @GetMapping("/add")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers/list";
    }

    // @GetMapping("/update/{id}")
    // public String showUpdateCustomerForm(@PathVariable("id") Long id, Model
    // model) {
    // // Customer customer = customerRepository.findById(id)
    // .orElseThrow(() -> new IllegalArgumentException("Invalid customer id: " +
    // id));
    // model.addAttribute("customer", customer);
    // return "customer-form";
    // }

//    @GetMapping("/delete")
//    public String deleteCustomer(@PathVariable("id") Long id) {
//        customerRepository.deleteById(id);
//        return "redirect:deleteCustomer";
//    }
    @GetMapping("/delete")
    public String deleteCustomer(Model model) {
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "deleteCustomer";
    }

}

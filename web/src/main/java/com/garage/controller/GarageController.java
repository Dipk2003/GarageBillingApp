package com.garage.controller;

import com.garage.model.Customer;
import com.garage.model.Car;
import com.garage.model.Service;
import com.garage.service.GarageWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GarageController {
    
    @Autowired
    private GarageWebService garageService;
    
    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
    
    @GetMapping("/customers")
    public String showCustomers(Model model) {
        model.addAttribute("customers", garageService.getAllCustomers());
        return "customers";
    }
    
    @GetMapping("/add-customer")
    public String showAddCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "add-customer";
    }
    
    @PostMapping("/add-customer")
    public String addCustomer(@RequestParam String name, 
                             @RequestParam String phone, 
                             @RequestParam String carNumber, 
                             @RequestParam String model) {
        garageService.addCustomer(name, phone, carNumber, model);
        return "redirect:/customers";
    }
    
    @GetMapping("/services")
    public String showServices(Model model) {
        model.addAttribute("services", garageService.getAvailableServices());
        return "services";
    }
    
    @GetMapping("/invoice/{carNumber}")
    public String showInvoiceForm(@PathVariable String carNumber, Model model) {
        Customer customer = garageService.getCustomerByCarNumber(carNumber);
        if (customer == null) {
            return "redirect:/customers?error=notfound";
        }
        model.addAttribute("customer", customer);
        model.addAttribute("services", garageService.getAvailableServices());
        return "invoice";
    }
    
    @PostMapping("/generate-invoice")
    public String generateInvoice(@RequestParam String carNumber, 
                                 @RequestParam List<Integer> selectedServices,
                                 Model model) {
        String invoiceHtml = garageService.generateInvoice(carNumber, selectedServices);
        model.addAttribute("invoiceHtml", invoiceHtml);
        return "invoice-result";
    }
}

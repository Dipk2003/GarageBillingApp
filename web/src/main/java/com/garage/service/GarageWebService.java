package com.garage.service;

import com.garage.model.Customer;
import com.garage.model.Car;
import com.garage.model.Service;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GarageWebService {
    private Map<String, Customer> customersMap;
    private List<Service> availableServices;

    public GarageWebService() {
        this.customersMap = new HashMap<>();
        this.availableServices = new ArrayList<>();
        loadServices();
    }

    private void loadServices() {
        availableServices.add(new Service("Car Wash", 500));
        availableServices.add(new Service("Oil Change", 700));
        availableServices.add(new Service("Wheel Alignment", 300));
        availableServices.add(new Service("Tyre Replacement", 3000));
        availableServices.add(new Service("Puncture", 50));
    }

    public void addCustomer(String name, String phone, String carNumber, String model) {
        Car car = new Car(carNumber, model);
        Customer customer = new Customer(name, phone, car);
        customersMap.put(carNumber, customer);
    }

    public Customer getCustomerByCarNumber(String carNumber) {
        return customersMap.get(carNumber);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customersMap.values());
    }

    public List<Service> getAvailableServices() {
        return availableServices;
    }

    public String generateInvoice(String carNumber, List<Integer> serviceIndices) {
        Customer customer = customersMap.get(carNumber);
        if (customer == null) {
            return "<p>Customer not found</p>";
        }

        StringBuilder invoiceHtml = new StringBuilder();
        invoiceHtml.append("<div class='invoice'>");
        invoiceHtml.append("<h2>Invoice</h2>");
        invoiceHtml.append("<div class='customer-info'>");
        invoiceHtml.append("<p><strong>Customer:</strong> ").append(customer.getName()).append("</p>");
        invoiceHtml.append("<p><strong>Phone:</strong> ").append(customer.getPhone()).append("</p>");
        invoiceHtml.append("<p><strong>Car Model:</strong> ").append(customer.getCar().getModel()).append("</p>");
        invoiceHtml.append("<p><strong>Car Number:</strong> ").append(customer.getCar().getCarNumber()).append("</p>");
        invoiceHtml.append("</div>");
        
        invoiceHtml.append("<h3>Services:</h3>");
        invoiceHtml.append("<table class='services-table'>");
        invoiceHtml.append("<tr><th>Service</th><th>Price (₹)</th></tr>");
        
        double totalAmount = 0;
        for (int index : serviceIndices) {
            if (index >= 0 && index < availableServices.size()) {
                Service service = availableServices.get(index);
                invoiceHtml.append("<tr>");
                invoiceHtml.append("<td>").append(service.getName()).append("</td>");
                invoiceHtml.append("<td>₹").append(service.getPrice()).append("</td>");
                invoiceHtml.append("</tr>");
                totalAmount += service.getPrice();
            }
        }
        
        invoiceHtml.append("<tr class='total-row'>");
        invoiceHtml.append("<td><strong>Total Amount</strong></td>");
        invoiceHtml.append("<td><strong>₹").append(totalAmount).append("</strong></td>");
        invoiceHtml.append("</tr>");
        invoiceHtml.append("</table>");
        invoiceHtml.append("<p class='thank-you'>Thank You for choosing Bharti Car Service Center!</p>");
        invoiceHtml.append("</div>");

        return invoiceHtml.toString();
    }
}

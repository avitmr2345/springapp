package com.myfirst_springapp.springapp.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.myfirst_springapp.springapp.validation.Customer;
import jakarta.validation.Valid;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // it registers the StringTrimmer to the String class fields
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    // Model allows us to share information b/w Controllers and view
    // pages(Thymeleaf)
    @GetMapping("/customer")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    // @Valid tells Spring MVC to perform validation and the result of validation is
    // stored in theBindingResult
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult) {
        // check this for custom error names
        System.out.println("Binding Result: " + theBindingResult);

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}

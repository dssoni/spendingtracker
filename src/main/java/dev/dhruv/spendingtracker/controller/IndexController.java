package dev.dhruv.spendingtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.dhruv.spendingtracker.model.EmailForm;

@Controller
public class IndexController {
    
    @GetMapping("")
    public ModelAndView findAllCategories(Model model) {
        model.addAttribute("email", null);
        return new ModelAndView("hello.html");
    }

    @PostMapping("/process-email")
    public String processEmail(@ModelAttribute("emailForm") EmailForm emailForm) {
        // Access the email address entered by the user
        String userEmail = emailForm.email();
        
        System.out.println(userEmail);
        // Redirect to another page or perform further actions
        return "redirect:/success"; // Redirect to a success page
    }

    @GetMapping("/success")
    public String success() {
        return "success"; // Return the name of the success page template
    }

}

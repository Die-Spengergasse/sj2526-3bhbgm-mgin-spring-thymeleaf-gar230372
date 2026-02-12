package at.spengergasse.spring_thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//@ = annotation
//wird automatisch geladen
@Controller
public class HelloController {

    @GetMapping("") //getmapping
    public  String index(Model model) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        model.addAttribute("today", LocalDate.now().format(dtf));
        return "index";
    }

    //über menü - view - tool window - endpoints kann man sehen, welche seiten man aufrufen kann
    //hier: u.a. / (keine speziellere seite), /patient/list,...}
}

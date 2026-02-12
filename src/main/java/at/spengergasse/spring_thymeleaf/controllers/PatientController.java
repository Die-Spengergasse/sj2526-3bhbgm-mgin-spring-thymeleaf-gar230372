package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Patient;
import at.spengergasse.spring_thymeleaf.entities.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;

@Controller //das ist notation die drauf sein muss damit springboot weiß dass das eine controller klasse ist, die für die anfragen zuständig ist
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository; //kein "new" mehr nötig, springboot erstellt automatisch eine instanz von patientrepository und injiziert sie hier rein

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    //springboot findet patient repository, macht eine instanz davon
    @GetMapping("/list")
    public String patients(Model model) {
        model.addAttribute("patients", patientRepository.findAll()); //findall holt alle patienten aus db und übergibt sie als liste
        return "patlist";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add_patient";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientRepository.save(patient); //einfügen neuer patienten in db
        return  "redirect:/patient/list";
    }
}

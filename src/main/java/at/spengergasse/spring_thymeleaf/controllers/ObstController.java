package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Obst;
import at.spengergasse.spring_thymeleaf.entities.ObstRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/obst")
public class ObstController {
    private final ObstRepository obstRepository;

    public ObstController(ObstRepository obstRepository) {
        this.obstRepository = obstRepository;
    }

    // Alle Obstsorten auflisten
    @GetMapping ("/list")
    public String obst(Model model) {
        model.addAttribute("obst", obstRepository.findAll());
        return "obstlist";
    }

    // Neue Obstsorte hinzufügen
    @GetMapping ("/add")
    public String addObst(Model model) {
        model.addAttribute("obst", new Obst());
        return "add_obst";
    }

    // nach hinzufügen vom obst wird es gespeichert und man wird wieder auf die seite mit der liste zurückgeleitet
    @PostMapping("/add")
    public String addObst(@ModelAttribute ("obst") Obst obst) {
        obstRepository.save(obst);
        return "redirect:/obst/list";
    }

    //Obst bearbeiten (nach der Erstellung)
    @GetMapping("/edit")
    public String editObst(@RequestParam int id, Model model) {
        Obst obst = obstRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid obst Id:" + id)); //sucht das obst mit der id, damit kein neues erstellt wird und speichert die id in dem objekt "obst"
        model.addAttribute("obst", obst);
        return "add_obst";
    }

    //Obst löschen
    @GetMapping("/delete")
    public String deleteObst(Obst obst) {
        obstRepository.deleteById(obst.getId()); //Löscht das Obst anhand der Id (daran wird es gefunden damit das richtige gelöscht wird)
        return "redirect:/obst/list";
    }


}

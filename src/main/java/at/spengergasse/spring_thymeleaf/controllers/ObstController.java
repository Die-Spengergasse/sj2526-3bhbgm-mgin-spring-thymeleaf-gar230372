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

    @GetMapping ("/list")
    public String obst(Model model) {
        model.addAttribute("obst", obstRepository.findAll());
        return "obstlist";
    }

    @GetMapping ("/add")
    public String addObst(Model model) {
        model.addAttribute("obst", new Obst());
        return "add_obst";
    }

    @PostMapping("/add")
    public String addObst(@ModelAttribute ("obst") Obst obst) {
        obstRepository.save(obst);
        return "redirect:/obst/list";
    }

    @GetMapping("/edit")
    public String editObst(Model model, Obst obst){
        model.addAttribute("id", obstRepository.findById(obst.getId()));
        return "add_obst";
    }


}

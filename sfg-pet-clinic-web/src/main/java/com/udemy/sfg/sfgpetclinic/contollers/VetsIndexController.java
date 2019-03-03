package com.udemy.sfg.sfgpetclinic.contollers;

import com.udemy.sfg.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetsIndexController {

    private VetService vetService;

    public VetsIndexController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String vetsIndex(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/vetslist";
    }
}

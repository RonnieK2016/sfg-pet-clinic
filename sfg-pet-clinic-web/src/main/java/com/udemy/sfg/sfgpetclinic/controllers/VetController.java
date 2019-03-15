package com.udemy.sfg.sfgpetclinic.controllers;

import com.udemy.sfg.sfgpetclinic.model.Vet;
import com.udemy.sfg.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/", "/vets/index", "vets.html"})
    public String vetsIndex(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/vetslist";
    }

    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}

package com.udemy.sfg.sfgpetclinic.contollers;

import com.udemy.sfg.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersIndexController {

    private OwnerService ownerService;

    public OwnersIndexController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String ownersIndex(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/ownerslist";
    }

}

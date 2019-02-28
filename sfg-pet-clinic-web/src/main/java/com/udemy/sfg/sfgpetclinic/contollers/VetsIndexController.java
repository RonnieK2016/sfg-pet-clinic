package com.udemy.sfg.sfgpetclinic.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetsIndexController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String vetsIndex() {
        return "vets/vetslist";
    }
}

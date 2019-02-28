package com.udemy.sfg.sfgpetclinic.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsIndexController {

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String vetsIndex() {
        return "vets/vetslist";
    }
}

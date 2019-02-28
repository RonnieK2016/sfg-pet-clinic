package com.udemy.sfg.sfgpetclinic.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnersIndexController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String ownersIndex() {
        return "owners/ownerslist";
    }

}

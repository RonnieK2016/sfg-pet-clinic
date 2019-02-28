package com.udemy.sfg.sfgpetclinic.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {

    @RequestMapping({"","/","index","index.html"})
    public String indexPage() {
        return "index";
    }

}

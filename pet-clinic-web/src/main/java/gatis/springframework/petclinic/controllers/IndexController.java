package gatis.springframework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "/oups")
    public String oupsHandler() {
        return "notimplemented";
    }
}

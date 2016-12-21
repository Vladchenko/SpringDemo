package ru.vlad.yanchenko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Влад on 19.12.2016.
 */
@Controller
public class BasicController {

    private BasicController basicController;

    @RequestMapping("/demo1")
    public String demo1(Model model) {
        return "demo1";
    }

    public BasicController() {
    }

    public void setBasicController(BasicController basicController) {
        this.basicController = basicController;
    }

    public BasicController getBasicController() {
        return basicController;
    }
}

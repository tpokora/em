package org.tpokora.home.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static org.tpokora.home.views.HomeViewConstants.*;

@Controller
public class HomeViewController {

    @GetMapping(value = HOME_VIEW_URL, name = HOME_VIEW)
    public String home(Model model) {
        return "home";
    }

    @GetMapping(value = LOGIN_VIEW_URL, name = LOGIN_VIEW)
    public String login(Model model) {
        return "login";
    }


}
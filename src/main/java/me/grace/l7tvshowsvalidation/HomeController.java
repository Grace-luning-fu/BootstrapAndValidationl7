package me.grace.l7tvshowsvalidation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController
{
    @GetMapping("/index")
    public String dfindex(){
        return "index";
    }

    @GetMapping("/df")
    public String df(){
        return "indexbackup";
    }

    @GetMapping("/bstvform")
    public String bsloadTvForm(Model model){
        model.addAttribute("tvshow", new Tvshow());
        return "bstvform";
    }

    @PostMapping("/bstvform")
    public String bsprocessTvForm(@Valid Tvshow tvshow, BindingResult br) {
        if (br.hasErrors()) {
            return "bstvform";
        }
        return "bstvshowconfirm";
    }

    @GetMapping("/tvform")
    public String loadTvForm(Model model){
        model.addAttribute("tvshow", new Tvshow());
        return "tvform";
    }

    @PostMapping("/tvform")
    public String processTvForm(@Valid Tvshow tvshow, BindingResult br) {
        if (br.hasErrors()) {
            return "tvform";
        }
        return "tvshowconfirm";
    }

}

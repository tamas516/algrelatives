package hu.nye.algrelatives.controller;

import java.util.List;

import hu.nye.algrelatives.model.Relative;
import hu.nye.algrelatives.repositories.RelativeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/relatives")
public class RelativeController {

    @Autowired
    public RelativeRepo relativeRepo;

    @GetMapping
    public String getAll(final Model model) {
        final List<String[]> relatives =  relativeRepo.findByAdmin();
        model.addAttribute("relatives", relatives);
        return "relatives/list";
    }
}

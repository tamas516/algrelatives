package hu.nye.algrelatives.controller;

import java.util.ArrayList;
import java.util.List;

import hu.nye.algrelatives.repositories.RelativeRepo;
import hu.nye.algrelatives.repositories.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/relatives")
public class RelativeController {

    @Autowired
    public RelativeRepo relativeRepo;


    @Autowired
    public RepoService repoService;

    @GetMapping
    public String showForm(){
        return "relatives/list";
    }

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String fdfd(){
        return "relatives/index";
    }

    @RequestMapping(path = "/belepetfooldal", method = RequestMethod.GET)
    public String akarmi(){
        return "relatives/belepetfooldal";
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String listByName(final Model model, @Param("keyword") String keyword) {
        System.out.println("Keyword: "+keyword);
        final String id = relativeRepo.getId(keyword);
            final List<String[]> relatives = relativeRepo.listByName(id);
            model.addAttribute("relatives", relatives);
            final List<String[]> relatives2 = relativeRepo.listByName2(id);
            model.addAttribute("relatives2", relatives2);
            model.addAttribute("name",keyword);
        final List<String[]> relatives3 = relativeRepo.listByName3(id);
        model.addAttribute("relatives3", relatives3);
        return "relatives/search_result";
    }


    @RequestMapping(path = "/adatokfelvitele1", method = RequestMethod.GET)
    public String ins(){

            return "relatives/adatokfelvitele";
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @RequestMapping(path = "/kapcsolat1", method = RequestMethod.GET)
    public String kap(final Model model){
        final List<String[]> name = relativeRepo.getName();
        model.addAttribute("kap", name);

        final List<String[]> rel = relativeRepo.getRel();

        model.addAttribute("kapnev", rel);

        return "relatives/kapcsolat";
    }

    @RequestMapping(path = "/adatokfelvitele", method = RequestMethod.GET)
    public String insertNewRelative(final Model model, @Param("name") String name, @Param("birth_name") String birth_name
    , @Param("address") String address, @Param("birth_place") String birth_place, @Param("date_of_birth") String date_of_birth,
                                    @Param("gender") String gender) {
        relativeRepo.insertNewRelative(name, birth_name, address, birth_place,
                date_of_birth, gender);

        return "relatives/adatokfelvitele";
    }

    @RequestMapping(path = "/kapcsolat", method = RequestMethod.GET)
    public String getName(final Model model,  @Param("neki") String neki, @Param("o") String o
            , @Param("valakije") String valakije) {

        final String getfdname = relativeRepo.getfdname(valakije);

        relativeRepo.insertNewRel(neki,o,getfdname,valakije);

        return "relatives/kapcsolat";
    }

    @GetMapping("/persistMessage")
    public String process(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String[]> messages = (List<String[]>) session.getAttribute("MY_SESSION_MESSAGES");

        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);

        return "relatives/list";
    }

    @PostMapping("/persistMessage")
    public String persistMessage(Model model, @RequestParam("msg") String[] msg, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        List<String[]> messages = (List<String[]>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
        }
        messages.add(msg);
        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
        model.addAttribute("sessionMessages", messages);
        return "relatives/list";
    }

    @PostMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "relatives/list";
    }


}

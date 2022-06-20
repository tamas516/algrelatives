package hu.nye.algrelatives.controller;

import java.util.ArrayList;
import java.util.List;

import hu.nye.algrelatives.exception.RelativeAlreadyExistsException;
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
    public String showForm(final Model model){
        final List<String[]> name = relativeRepo.getName();
        model.addAttribute("kap", name);
        return "relatives/index";
    }


    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String listByName(final Model model, @Param("keyword") String keyword) {
        System.out.println("Keyword: "+keyword);
        final String id = relativeRepo.getId(keyword);
        if(id!=null)
        {
            final List<String[]> relatives = relativeRepo.listByName(id);
            model.addAttribute("relatives", relatives);
            final List<String[]> relatives2 = relativeRepo.listByName2(id);
            model.addAttribute("relatives2", relatives2);
            model.addAttribute("name",keyword);
            final List<String[]> relatives3 = relativeRepo.listByName3(id);
            model.addAttribute("relatives3", relatives3);

            return "relatives/search_result";
        }
          else
        {
            final List<String[]> name = relativeRepo.getName();
            model.addAttribute("kap", name);
            model.addAttribute("errorMessage","Kötelező nevet választani!");
            return "relatives/index";
        }
    }


    @RequestMapping(path = "/adatokfelvitele1", method = RequestMethod.GET)
    public String ins(){

            return "relatives/adatokfelvitele";
    }

    @RequestMapping(path = "/kapcsolat1", method = RequestMethod.GET)
    public String kap(final Model model){
        final List<String[]> name = relativeRepo.getName();
        model.addAttribute("kap", name);

        final List<String[]> rel = relativeRepo.getRel();
        final List<String[]> rel1 = relativeRepo.getRel1();

        model.addAttribute("kapnev", rel);
        model.addAttribute("kapnev1", rel1);


        return "relatives/kapcsolat";
    }

    @RequestMapping(path = "/adatokfelvitele", method = RequestMethod.GET)
    public String insertNewRelative(final Model model, @Param("name") String name, @Param("birth_name") String birth_name
    , @Param("address") String address, @Param("birth_place") String birth_place, @Param("date_of_birth") String date_of_birth,
                                    @Param("gender") String gender) {
        final String name1=relativeRepo.getName1(name);
        if(name1==null){
            relativeRepo.insertNewRelative(name, birth_name, address, birth_place,
                    date_of_birth, gender);

            final String siker="Sikeres adatfelvitel!";
            model.addAttribute("siker",siker);

            return "relatives/adatokfelvitele";
        }
        else
        {
            model.addAttribute("errorMessage","Már van ilyen nevű rokon");
            return "relatives/adatokfelvitele";
        }

    }

    @RequestMapping(path = "/kapcsolat", method = RequestMethod.GET)
    public String getName(final Model model,  @Param("neki") String neki, @Param("o") String o
            , @Param("valakije") String valakije, @Param("valakije1") String valakije1) {

        final List<String[]> name = relativeRepo.getName();
        model.addAttribute("kap", name);

        final List<String[]> rel = relativeRepo.getRel();
        final List<String[]> rel1 = relativeRepo.getRel1();

        model.addAttribute("kapnev", rel);
        model.addAttribute("kapnev1", rel1);
        final String name2 = relativeRepo.getName2(neki,o);

        final String name3 = relativeRepo.getName3(neki,o);

        if(name2==null && valakije1!=null && !neki.equals(o))
        {
            valakije=null;
            if(valakije==null) {

                final String getfdname1 = relativeRepo.getfdname1(valakije1);

                relativeRepo.insertNewRel1(neki, o, getfdname1, valakije1);

                final String siker = "Sikeres adatfelvitel!";
                model.addAttribute("siker", siker);

                return "relatives/kapcsolat";
            }
            else
            {
                model.addAttribute("errorMessage","Csak egy kapcsolattípus lehet!");
                return "relatives/kapcsolat";
            }
        }
        else  if(name3==null && valakije!=null && !neki.equals(o))
        {
            valakije1=null;
            if(valakije1==null) {

                final String getfdname = relativeRepo.getfdname(valakije);

                relativeRepo.insertNewRel(neki, o, getfdname, valakije);

                final String siker = "Sikeres adatfelvitel!";
                model.addAttribute("siker", siker);

                return "relatives/kapcsolat";
            }
            else
            {
                model.addAttribute("errorMessage","Csak egy kapcsolattípus lehet!");
                return "relatives/kapcsolat";
            }
        }
        else
        {
            model.addAttribute("errorMessage","Különböző személyeket adhat meg!");
            return "relatives/kapcsolat";
        }


    }

//    @GetMapping("/persistMessage")
//    public String process(Model model, HttpSession session) {
//        @SuppressWarnings("unchecked")
//        List<String[]> messages = (List<String[]>) session.getAttribute("MY_SESSION_MESSAGES");
//
//        if (messages == null) {
//            messages = new ArrayList<>();
//        }
//        model.addAttribute("sessionMessages", messages);
//
//        return "relatives/list";
//    }
//
//    @PostMapping("/persistMessage")
//    public String persistMessage(Model model, @RequestParam("msg") String[] msg, HttpServletRequest request) {
//        @SuppressWarnings("unchecked")
//        List<String[]> messages = (List<String[]>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
//        if (messages == null) {
//            messages = new ArrayList<>();
//            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        }
//        messages.add(msg);
//        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
//        model.addAttribute("sessionMessages", messages);
//        return "relatives/list";
//    }
//
//    @PostMapping("/destroy")
//    public String destroySession(HttpServletRequest request) {
//        request.getSession().invalidate();
//        return "relatives/list";
//    }


}

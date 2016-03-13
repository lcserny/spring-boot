package com.cserny.test.controller;

import com.cserny.test.entity.User;
import com.cserny.test.model.CsvParser;
import com.cserny.test.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 09.03.2016.
 */
@Controller
@RequestMapping("/second")
public class SecondController
{
    @Autowired
    private MainService service;

    @RequestMapping("/aaa")
    public String newJspPage()
    {
        return "aaa";
    }

    @RequestMapping("/jsp")
    public ResponseEntity<String> testMethod()
    {
        return new ResponseEntity<String>("test", HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegistrationPage(@ModelAttribute(value = "user")User user )
    {
        return "registrationPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String submitRegistration(@Valid @ModelAttribute(value = "user") User user,
                                     BindingResult result,
                                     Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("success", false);
        } else {
            model.addAttribute("success", true);
        }

        return "registrationPage";
    }

    @RequestMapping("/parse-csv")
    @ResponseBody
    public String displayParsedCsv()
    {
        CsvParser parser = new CsvParser();
        StringBuilder builder = new StringBuilder();
        List<String> parsedCsv = parser.parseCsv();

        for (String line : parsedCsv) {
            builder.append(line).append("<br>");
        }

        return builder.toString();
    }
}

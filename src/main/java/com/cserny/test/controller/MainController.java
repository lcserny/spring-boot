package com.cserny.test.controller;

import com.cserny.test.entity.User;
import com.cserny.test.model.JsonResponse;
import com.cserny.test.service.MainService;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 07.03.2016.
 */
@Controller
@RequestMapping("/home")
public class MainController
{
    protected MainService mainService;
    protected int localValue = 5;

    @Autowired
    public void setMainService(MainService mainService)
    {
        this.mainService = mainService;
    }

    @RequestMapping(value = "/jsp/both", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getJsonVersion(Model model,
                                       @Valid@ModelAttribute(value = "user") User user,
                                       @RequestParam(value = "testReqParam", required = false) String requestParam,
                                       HttpServletRequest request)
    {
        Integer value = mainService.getValue();
        model.addAttribute("value", value);
        model.addAttribute("localValue", localValue);

//        throw new RuntimeException("ERROR"+" reqParam ="+requestParam);
        return new ModelAndView("main", model.asMap());
    }

    @RequestMapping("/jsp")
    public ModelAndView getJspSecondVersion()
    {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("value", mainService.getValue());
        modelMap.addAttribute("localValue", localValue);

        return new ModelAndView("main", modelMap);
    }

    @RequestMapping("/jsp/param")
    public ResponseEntity<String> newMethod()
    {
        return new ResponseEntity<String>("test", HttpStatus.I_AM_A_TEAPOT);
    }

    @RequestMapping("/json")
    public ResponseEntity<JsonResponse> getJspVersion()
    {
        JsonResponse response = new JsonResponse("Leo", new Date());
        ResponseEntity<JsonResponse> responseEntity = new ResponseEntity(response, HttpStatus.OK);

        return responseEntity;
    }

    @RequestMapping("/test-address")
    @ResponseBody
    public String getRequestVersion(HttpServletRequest request)
    {
        return request.getRequestURI() + " -------- " + request.getRequestURL();
    }

    @RequestMapping("/upper")
    @ResponseBody
    public String displayUpperFirstLetterWords()
    {
        String text = "this is some text";

        long startTime = System.nanoTime();
        String[] words = text.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            String newWord = Character.toString(Character.toUpperCase(word.charAt(0))) + word.substring(1);
            builder.append(newWord).append(" ");
        }
        String result = builder.toString().trim();
        long duration = System.nanoTime() - startTime;
        System.out.println(duration);

        return result;
    }

    @RequestMapping("/get-leo-user")
    @ResponseBody
    public String getUserNameVersion()
    {
        return mainService.getUserName("Leo");
    }

    @ResponseBody
    @RequestMapping("/all-usernames")
    public String getAllUserNamesVersion()
    {
        return mainService.getAllEntityNames();
    }

    @RequestMapping("/")
    @ResponseBody
    public String getBodyVersion()
    {
        mainService.createNewUserWithName("Leo");
        return "Added new Entity : Leo";
    }
}

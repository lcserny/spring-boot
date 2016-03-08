package com.cserny.test.controller;

import com.cserny.test.model.JsonResponse;
import com.cserny.test.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by user on 07.03.2016.
 */
@Controller
public class MainController
{
    protected MainService mainService;
    protected int localValue = 5;

    @Autowired
    public void setMainService(MainService mainService)
    {
        this.mainService = mainService;
    }

    @RequestMapping("/jsp")
    public String getJsonVersion(Model model)
    {
        Integer value = mainService.getValue();
        model.addAttribute("value", value);
        model.addAttribute("localValue", localValue);

        return "main";
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

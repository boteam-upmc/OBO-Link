package org.upmc.obolink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.upmc.obolink.model.User;
import org.upmc.obolink.service.*;

@Controller
public class ControlController {

    private final ControlService controlService;
    private final UserService userService;

    @Autowired
    public ControlController(UserService userService, ControlService controlService) {
        this.controlService = controlService;
        this.userService = userService;
    }


    @RequestMapping(value = {"/control/{robotID}"}, method = RequestMethod.GET)
    public ModelAndView control(@PathVariable int robotID) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        ModelAndView modelAndView = new ModelAndView();
        if(controlService.checkRobotAndAssociation(robotID, user)){
            modelAndView.addObject("user", user);
            modelAndView.addObject("robotID", robotID);
            modelAndView.setViewName("controlRobotLive");
            return modelAndView;
        }
        return new ModelAndView("redirect:/videos/"+robotID);
    }


}

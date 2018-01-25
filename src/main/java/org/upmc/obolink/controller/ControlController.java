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

/**
 * The controller that will manage the remote control of the robot.
 *
 * @author boteam
 * @version 1.0
 */
@Controller
public class ControlController {

    private final ControlService controlService;
    private final UserService userService;

    @Autowired
    public ControlController(UserService userService, ControlService controlService) {
        this.controlService = controlService;
        this.userService = userService;
    }

    /**
     * Handle the request Get for "/control/"
     * Allow accesses the Robot Control Page and Live Robot Visual.
     * @param robotID number that identifies the robot.
     * @return controlRobotLive.html
     */
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

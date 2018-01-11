package org.upmc.obolink.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.upmc.obolink.model.Robot;
import org.upmc.obolink.model.RobotUser;
import org.upmc.obolink.model.User;
import org.upmc.obolink.service.RobotService;
import org.upmc.obolink.service.RobotUserService;
import org.upmc.obolink.service.UserService;

import java.util.List;

/**
 * The controller who will handle everything associated with the login and registration.
 *
 * @author boteam
 * @version 1.0
 */
@Controller
public class RobotController {
    private final UserService userService;
    private final RobotUserService robotUserService;

    @Autowired
    public RobotController(UserService userService, RobotUserService robotUserService, RobotService robotService) {
        this.userService = userService;
        this.robotUserService = robotUserService;
    }

    /**
     *  Handle the request GET when accessing the "/association" page of the website.
     *  Get all the robots who are associated with the user.
     *
     * @return association.html and the RobotUser list for the user.
     */
    @RequestMapping(value = "association", method = {RequestMethod.GET})
    public ModelAndView assoc() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        List<RobotUser> userRobots = robotUserService.findByUserId(user.getId());
        modelAndView.addObject("userRobots", userRobots);
        modelAndView.setViewName("association");
        return modelAndView;
    }

    /**
     * Handle the request POST for "/associate". It's called when the user accept the association with the robot.
     * The association RobotUser is set to associated in the database.
     *
     * @param idRobot The id of the robot.
     * @return association.html
     */
    @RequestMapping(value = "associate", method = RequestMethod.POST)
    public ModelAndView associate(@RequestParam("id") int idRobot) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        RobotUser robotUser = robotUserService.getRobotUserByUserIdAndRobotId(user.getId(), idRobot);
        if (robotUser != null) {
            robotUser.setAssociated(true);
            robotUserService.saveUserRobots(robotUser);
        }
        modelAndView.setViewName("association");
        return modelAndView;
    }

    /**
     * Handle the request POST for "/dissociate". It's called when the user want to delete or
     * refuse the association with the robot.
     * The association RobotUser is deleted from the database.
     *
     * @param idRobot The id of the robot.
     * @return association.html
     */
    @RequestMapping(value = "dissociate", method = RequestMethod.POST)
    public ModelAndView dissociate(@RequestParam("id") int idRobot) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        RobotUser robotUser = robotUserService.getRobotUserByUserIdAndRobotId(user.getId(), idRobot);
        if (robotUser != null) {
            robotUserService.removeUserRobots(robotUser);
        }
        modelAndView.setViewName("association");
        return modelAndView;
    }
}

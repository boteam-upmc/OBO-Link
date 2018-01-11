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

@Controller
public class RobotController {

    private final UserService userService;
    private final RobotUserService robotUserService;
    private final RobotService robotService;

    @Autowired
    public RobotController(UserService userService, RobotUserService robotUserService, RobotService robotService) {
        this.userService = userService;
        this.robotUserService = robotUserService;
        this.robotService = robotService;
    }

    @RequestMapping(value = "association", method = {RequestMethod.GET})
    public ModelAndView assoc() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        List<RobotUser> userRobots = robotUserService.findByUserId(user.getId());
        //List<Robot> robots = robotService.findByUserRobots(userRobots);
        modelAndView.addObject("userRobots", userRobots);
        //modelAndView.addObject("robots", robots);
        modelAndView.setViewName("association");
        return modelAndView;
    }

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

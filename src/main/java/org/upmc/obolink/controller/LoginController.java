package org.upmc.obolink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.upmc.obolink.model.User;
import org.upmc.obolink.service.UserService;

import javax.validation.Valid;

/**
 * The controller who will handle everything associated with the login and registration.
 *
 * @author boteam
 * @version 1.0
 */
@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handle the request GET when accessing the "/" or the "/login" page of the website.
     *
     * @return If the user is not logged, it will return login.html.
     * If the user is logged, then he will be redirected to "/association"
     *
     * @see RobotController#assoc()
     */
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/association");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * Handle the request GET when accessing "/registration" page of the website.
     *
     * @return If the user is not logged, it will return registration.html.
     * If the user is logged, then he will be redirected to "/association"
     *
     * @see RobotController#assoc()
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/association");
        }
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    /**
     * Handle the request POST send by the registration form. If the data filed by the user is good,
     * a new User will be created.
     *
     * @param user The form data filed by the user.
     * @param bindingResult Allow to send errors to the user.
     * @return Send a success message or errors to the user to be display.
     *
     * @see User
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    /**
     *  Handle the request GET when accessing "/admin/home" page of the website.
     *
     * @return If the user is logged has an admin, home/admin.html will be send.
     */
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    /**
     * Handle the request GET when accessing "/admin/home" page of the website. Most of the time,
     * the user will be redirected to this page when he tries to access a forbidden web page.
     *
     * @return access-denied.html
     */
    @RequestMapping(value = "access-denied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("access-denied");
        return modelAndView;
    }
}

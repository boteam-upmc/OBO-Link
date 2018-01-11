package org.upmc.obolink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.upmc.obolink.configuration.WebMvcConfig;
import org.upmc.obolink.model.User;
import org.upmc.obolink.model.Video;
import org.upmc.obolink.service.UserService;
import org.upmc.obolink.service.VideoService;

import java.io.File;
import java.util.List;

/**
 * The controller who will handle everything associated with the profile.
 *
 * @author boteam
 * @version 1.0
 */
@Controller
public class ProfileController {

    private final UserService userService;
    private final VideoService videoService;

    @Autowired
    public ProfileController(UserService userService, VideoService videoService) {
        this.userService = userService;
        this.videoService = videoService;
    }


    /**
     * Handle the request GET when accessing the "/profile/delete" of the website. Most of the time,
     * the user will be redirected to this page when he clicks on the delete button in the profile.
     * It will remove the User of the website.
     *
     * @return The user will be redirected to "/logout".
     *
     * @see User
     */
    @RequestMapping(value = {"/profile/delete"}, method = RequestMethod.GET)
    public ModelAndView profileDelete() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        List<Video> videoList = videoService.findByUserId(user.getId());
        for (int i = 0; i < videoList.size(); i++) {
            Video video = videoList.get(i);
            try{
                File file = new File(WebMvcConfig.getRessourcesPathA() + video.getVideoURL());
                File file2 = new File(WebMvcConfig.getRessourcesPathA() + video.getImageURL());
                if(!file.delete() || !file2.delete()) {
                    System.out.println("Delete operation failed for one video.");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            videoService.removeVideo(video);
        }
        userService.removeUser(user);
        modelAndView.setViewName("redirect:/logout");
        return modelAndView;
    }

    /**
     * Handle the request GET when accessing the "/profile"
     *
     * @return profile.html
     */
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}

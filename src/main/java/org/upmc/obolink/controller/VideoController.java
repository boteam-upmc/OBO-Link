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
import org.upmc.obolink.model.Video;
import org.upmc.obolink.service.UserService;
import org.upmc.obolink.service.VideoService;

import java.util.List;

@Controller
public class VideoController {

    private final VideoService videoService;

    private final UserService userService;

    @Autowired
    public VideoController(UserService userService, VideoService videoService) {
        this.userService = userService;
        this.videoService = videoService;
    }

    @RequestMapping(value = "videos", method = RequestMethod.GET)
    public ModelAndView videos() {
        ModelAndView modelAndView = new ModelAndView();
        List<Video> videos;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        videos = videoService.findByUserId(user.getId());
        modelAndView.addObject("videos", videos);
        modelAndView.setViewName("videos");
        return modelAndView;
    }

    @RequestMapping(value = "videos/{videoID}", method = RequestMethod.GET)
    public ModelAndView videosID(@PathVariable int videoID) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());

        Video video = videoService.findById(videoID);
        modelAndView.addObject("video", video);
        modelAndView.setViewName("play");
        return modelAndView;
    }

}

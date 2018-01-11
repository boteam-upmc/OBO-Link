package org.upmc.obolink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
 * The controller who will handle everything associated with the videos.
 *
 * @author boteam
 * @version 1.0
 */
@Controller
public class VideoController {

    private final VideoService videoService;

    private final UserService userService;

    @Autowired
    public VideoController(UserService userService, VideoService videoService) {
        this.userService = userService;
        this.videoService = videoService;
    }

    /**
     *  Handle the request GET when accessing the "/videos/{robotId}" page of the website.
     *  Get all the videos who are associated with the user and the robot.
     *
     * @return videos.html and the videos list for the user and the robot.
     */
    @RequestMapping(value = "videos/{robotID}", method = RequestMethod.GET)
    public ModelAndView videos(@PathVariable int robotID) {
        ModelAndView modelAndView = new ModelAndView();
        List<Video> videos;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        videos = videoService.findByUserIdAndRobotId(user.getId(), robotID);
        modelAndView.addObject("videos", videos);
        modelAndView.addObject("robotId", robotID);
        modelAndView.setViewName("videos");
        return modelAndView;
    }

    /**
     *  Handle the request GET when accessing the "/videos/{robotId}/{videoId}" page of the website.
     *  Get the video selected by the user.
     *
     * @return play.html and the video.
     */
    @RequestMapping(value = "videos/{robotID}/{videoID}", method = RequestMethod.GET)
    public ModelAndView videosID(@PathVariable int videoID) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        Video video = videoService.findById(videoID);
        if (video != null && video.getUserId() == user.getId()) {
            modelAndView.addObject("video", video);
        } else {
            modelAndView.addObject("video", new Video());
        }
        modelAndView.setViewName("play");
        return modelAndView;
    }

    /**
     *  Handle the request GET when accessing the "/videos/{robotId}/delete" page of the website.
     *  Delete de video if the user didn't exceed the limit alpha.
     *
     * @return Redirect to videos/{RobotID} if it has been deleted, if not redirect to videos/{robotID}/{}
     */
    @RequestMapping(value = "videos/{robotID}/{videoID}/delete", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int robotID, @PathVariable int videoID) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        Video video = videoService.findById(videoID);
        if (video != null && video.getUserId() == user.getId()
                && ((user.getNumberOfVideosDeleted()  * 100) / user.getNumberOfVideosTaken()) < user.getAlpha()) {
            user.setNumberOfVideosDeleted(user.getNumberOfVideosDeleted() + 1);
            try{
                File file = new File(WebMvcConfig.getRessourcesPathA() + video.getVideoURL());
                File file2 = new File(WebMvcConfig.getRessourcesPathA() + video.getImageURL());
                if(!file.delete() || !file2.delete()) {
                    System.out.println("Delete operation failed.");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            videoService.removeVideo(video);
            return new ModelAndView("redirect:/videos/"+robotID);
        } else {
            return new ModelAndView("redirect:/videos/"+robotID+"/"+videoID);
        }
    }

}

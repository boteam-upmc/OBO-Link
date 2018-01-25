package org.upmc.obolink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.Video;
import org.upmc.obolink.repository.VideoRepository;

import java.sql.Timestamp;
import java.util.List;

/**
 * The implementation of the video Service.
 */
@Service("videoService")
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(@Qualifier("videoRepository") VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    /**
     * Search in the database for all the videos for a user.
     * @param id the id of the user.
     * @return a list of videos for the user.
     */
    @Override
    public List<Video> findByUserId(int id) {
        return videoRepository.findByUserId(id);
    }

    /**
     * Search in the database for a specific video.
     * @param videoID the id of the video.
     * @return the video.
     */
    @Override
    public Video findById(int videoID) { return videoRepository.findById(videoID);
    }

    /**
     * Search in the database for a list of video for a user, a robot, and after a creation date.
     * @param id the user id
     * @param robotId the robot id
     * @return a list of video
     */
    @Override
    public List<Video> findByUserIdAndRobotId(int id, int robotId) {
        Timestamp date = new Timestamp(System.currentTimeMillis()- (24 * 60 * 60 * 1000));
        return videoRepository.findByUserIdAndRobotIdAndCreationDateIsAfter(id, robotId, date);
    }

    /**
     * Remove a user from the database.
     * @param video the user
     * @see Video
     */
    @Override
    public void removeVideo(Video video) {
        videoRepository.  delete(video);
    }
}

package org.upmc.obolink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.upmc.obolink.model.Video;
import org.upmc.obolink.repository.VideoRepository;

import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(@Qualifier("videoRepository") VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> findByUserId(int id) {
        return videoRepository.findByUserId(id);
    }

    @Override
    public Video findById(int videoID) { return videoRepository.findById(videoID);
    }

    @Override
    public List<Video> findByUserIdAndRobotId(int id, int robotId) {
        return videoRepository.findByUserIdAndRobotId(id, robotId);
    }
}

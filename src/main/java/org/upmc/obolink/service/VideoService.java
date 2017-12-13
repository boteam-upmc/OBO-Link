package org.upmc.obolink.service;

import org.upmc.obolink.model.Video;

import java.util.List;

public interface VideoService {
    List<Video> findByUserId(int id);
    Video findById(int videoID);
}

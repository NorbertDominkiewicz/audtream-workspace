package com.audtream.audtreamserver.repository;

import com.audtream.audtreamserver.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {
    List<Track> findByUserId(Long userId);
    List<Track> findByUserIdAndTitleContaining(Long userId, String title);
}

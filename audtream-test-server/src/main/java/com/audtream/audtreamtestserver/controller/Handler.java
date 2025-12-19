package com.audtream.audtreamtestserver.controller;

import com.audtream.audtreamtestserver.model.dto.TrackResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Handler {
    @GetMapping(path = "/desktop/track")
    public TrackResponse getTrack(@RequestParam int id) {
        return new TrackResponse(id, "Beautiful Lies", "Birdy", 206);
    }
}

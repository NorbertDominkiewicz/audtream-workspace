package com.audtream.audtreamserver.controller;


import com.audtream.audtreamserver.model.dto.desktop.TrackResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/desktop")
public class DesktopController {
    @GetMapping(path = "/track")
    public TrackResponse getTrack(@RequestParam long id) {
        return new TrackResponse(id, "Snowman", "Sia", 186);
    }
}

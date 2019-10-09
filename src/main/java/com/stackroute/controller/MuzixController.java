package com.stackroute.controller;


import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
@RestController
@RequestMapping(value = "/api/v1")
@Api(value="trackList", description="songs, description")
public class MuzixController {
    TrackService trackService ;

    @Autowired
    public TrackController(TrackService trackService) {

        this.trackService = trackService;
    }

    @ApiOperation(value = "adds a new track ")
    @PostMapping(value = "/track")
    public ResponseEntity<?> saveUser(@RequestBody Track track) throws TrackAlreadyExistException {
        ResponseEntity responseEntity;

        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping(value = "/track")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<List<Track>>(trackService.getAll(),HttpStatus.OK);
    }
    @ApiOperation(value = "search for a  track with a given name")
    @GetMapping(value = "/track/{trackName}")
    public ResponseEntity<> searchTrack(@PathVariable String trackName)
    {
        return new ResponseEntity<>(trackService.searchTrack(trackName),HttpStatus.OK);
    }


    @ApiOperation(value = "updates track")
    @ApiResponses(
            value = { @ApiResponse(code = 401,message = "done"),
                    @ApiResponse(code = 201,message = "returning the whole track")}
    )
    @PutMapping(value="/track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {


        trackService.updateTrack(track);
        ResponseEntity responseEntity = new ResponseEntity<Track>(track,HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping(value = "/track/{trackId}")
    public ResponseEntity<?> removeTrack(@PathVariable int trackId) throws TrackNotFoundException
    {

        trackService.deleteTrack(trackId);
        ResponseEntity<?> responseEntity = new ResponseEntity<String>(trackId+"is deleted",HttpStatus.OK);

        return responseEntity;
    }

}
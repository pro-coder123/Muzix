package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    Track saveTrack(Track track)throws TrackAlreadyExistException;

    List<Track> getAll();

    void deleteTrack(int id) throws TrackNotFoundException;


    void updateTrack(Track track) throws TrackNotFoundException;

    Optional<Track> searchTrack();

}

package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TrackServiceImpl implements TrackService {


    TrackRepository trackRepository;


    @Autowired
    public TrackServiceImpl(trackRepository movieRepository) {
        this.trackRepository = movieRepository;
    }

    @Override
     Track saveTrack(Track track) {

        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
     List<Track> getAll() {


        return trackRepository.findAll();
    }

    @Override
     void deleteTrack(int id) throws TrackNotFoundException{
        if(trackRepository.existsById(id)){
            trackRepository.deleteById(id);
        }
        else {
            throw new TrackNotFoundException("track does not exist");
        }




    }

    @Override
    void updateTrack(Track track) throws TrackNotFoundException
    {
        if(trackRepository.existsById(track.getId()))
            return;trackRepository.save(track);

            else throw new TrackNotFoundException("no track with given ID");
    }

    @Override
    Optional<Track> searchTrack(String name)
    {
        return trackRepository.trackSearch(name);
    }

}

package com.stackroute.repository;

import com.stackroute.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track,Integer> {



    @Query("select * from Tracks t where t.name = :name")
    Optional<Track> trackSearch(@Param("name") String name);


}

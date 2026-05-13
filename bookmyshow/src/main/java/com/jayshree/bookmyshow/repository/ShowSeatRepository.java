package com.jayshree.bookmyshow.repository;

import com.jayshree.bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>
{
    List<ShowSeat> findByShowId(Long movieId);

    List<ShowSeat> findByShowAndStatus(Long showId, String status);
}

package com.jayshree.bookmyshow.repository;

import com.jayshree.bookmyshow.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

    List<Theater> findByShowId(String city);

}

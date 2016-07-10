package com.tphuocthai.rest.repositories;

import com.tphuocthai.rest.entity.RestMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository access data from DB
 * Created by tphuocthai on 7/10/16.
 */
@Repository
public interface RestMeasureRepository extends JpaRepository<RestMeasure, Long> {
}

package com.tphuocthai.rest.controllers;

import com.tphuocthai.rest.entity.RestMeasure;
import com.tphuocthai.rest.repositories.RestMeasureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Rest request controller
 * Created by tphuocthai on 7/9/16.
 */
@Controller
@RequestMapping("/rest")
public class RestController {

    private static Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private RestMeasureRepository restMeasureRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RestMeasure> getAll() {
        log.debug("Get all RestMeasures");
        return restMeasureRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RestMeasure> getItem(@PathVariable Long id) {
        log.debug("Get RestMeasure by id: {}", id);
        RestMeasure restMeasure = restMeasureRepository.findOne(id);
        if (restMeasure == null) {
            return new ResponseEntity<RestMeasure>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RestMeasure>(restMeasure, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestMeasure createRestMeasure(@RequestBody RestMeasure restMeasure) {
        log.debug("Create RestMeasure: {}", restMeasure);
        long currentTime = new Date().getTime();

        restMeasure.setTimeInMilliseconds(currentTime);
        restMeasure.setCreatedBy(1);
        restMeasure.setCreatedAt(currentTime);
        restMeasure.setLastUpdatedBy(1);
        restMeasure.setLastUpdatedAt(currentTime);

        return restMeasureRepository.save(restMeasure);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    @ResponseBody
    public ResponseEntity<RestMeasure> updateRestMeasure(@PathVariable("id") Long id, @RequestBody RestMeasure updateValues) {
        log.debug("Update RestMeasure id: {}", id);
        RestMeasure restMeasure = restMeasureRepository.findOne(id);
        if (restMeasure == null) {
            log.info("RestMeasure {} not found", id);
            return new ResponseEntity<RestMeasure>(HttpStatus.NOT_FOUND);
        }

        restMeasure.setRestMethod(updateValues.getRestMethod());
        restMeasure.setRestMethodName(updateValues.getRestMethodName());
        restMeasure.setLastUpdatedBy(1);
        restMeasure.setLastUpdatedAt(new Date().getTime());

        return new ResponseEntity<RestMeasure>(restMeasureRepository.save(restMeasure), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<RestMeasure> deleteItem(@PathVariable Long id) {
        log.debug("Delete RestMeasure by id: {}", id);
        RestMeasure measure = restMeasureRepository.findOne(id);
        if (measure == null) {
            log.info("RestMeasure {} not found", id);
            return new ResponseEntity<RestMeasure>(HttpStatus.NOT_FOUND);
        }
        restMeasureRepository.delete(id);
        return new ResponseEntity<RestMeasure>(measure, HttpStatus.OK);
    }
}

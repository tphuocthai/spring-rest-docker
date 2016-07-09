package com.tphuocthai.rest.controllers;

import com.tphuocthai.rest.entity.RestMeasure;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Rest request controller
 * Created by tphuocthai on 7/9/16.
 */
@Controller
@RequestMapping("/rest")
public class RestController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RestMeasure> getAll() {
        List<RestMeasure> restMeasures = new ArrayList<RestMeasure>();
        restMeasures.add(getMeasure("Get all RestMeasure", "GET"));
        restMeasures.add(getMeasure("GET one RestMeasure", "GET"));
        return restMeasures;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestMeasure getItem(@PathVariable Long id) {
        RestMeasure measure = getMeasure("Get all RestMeasure", "GET");
        measure.setId(id);
        return measure;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestMeasure createRestMeasure(@RequestBody RestMeasure restMeasure) {
        return restMeasure;
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    @ResponseBody
    public RestMeasure updateRestMeasure(@PathVariable("id") Long id, @RequestBody RestMeasure restMeasure) {
        return restMeasure;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteItem(@PathVariable Long id) {
        throw new UnsupportedOperationException("Delete action " + id);
    }

    private RestMeasure getMeasure(String name, String method) {
        RestMeasure measure = new RestMeasure();
        measure.setRestMethodName(name);
        measure.setRestMethod(method);
        measure.setTimeInMiliseconds(new Date().getTime());
        measure.setCreatedAt(new Date().getTime());
        measure.setCreatedBy(1);
        measure.setLastUpdatedAt(new Date().getTime());
        measure.setLastUpdatedBy(1);
        return measure;
    }
}

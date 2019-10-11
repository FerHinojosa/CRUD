/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.progra.crud.controller;

import com.progra.crud.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Implements main classes.
 *
 * @author Fernando Hinojosa Sanchez 10/09/2019.
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/")
public class ManagerController {

    /*@Autowired
    private Car car;
    WebsiteService service;
    @GetMapping("/car/{id}")
    public ResponseEntity<WebsiteVo> getWebsite(@PathVariable Integer id) {
        return new ResponseEntity<WebsiteVo>(service.getWebsiteById(id), HttpStatus.OK);
    }
    @GetMapping("/car")
    public ResponseEntity<List<WebsiteVo>> getWebsiteList() {
        return new ResponseEntity<List<WebsiteVo>>(service.getWebsiteList(), HttpStatus.OK);
    }
    @PostMapping("/car")
    public ResponseEntity<String> saveWebsite(@RequestBody WebsiteVo websiteVo) {
        service.saveWebsite(websiteVo);
        return new ResponseEntity<String>("New website successfully saved", HttpStatus.OK);
    }
    @PutMapping("/car")
    public ResponseEntity<String> updateWebsite(@RequestBody WebsiteVo websiteVo) {
        service.updateWebsite(websiteVo);
        return new ResponseEntity<String>("New website successfully updated", HttpStatus.OK);
    }
    @DeleteMapping("/car")
    public ResponseEntity<String> deleteWebsite(@RequestBody WebsiteVo websiteVo) {
        service.deleteWebsite(websiteVo);
        return new ResponseEntity<String>("New website successfully deleted", HttpStatus.OK);
    }*/
}

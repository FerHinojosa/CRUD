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
    /**
     * Implements get method.
     * @return
     */
    @GetMapping("/get")
    public String GetHello(){
        return "HelloGet";
    }

    /**
     * Implements put method.
     * @return
     */
    @PutMapping("/put")
    public String PutHello(){
        return "HelloPut";
    }

    /**
     * Implements post method.
     * @return
     */
    @PostMapping("/post")
    public String PostHello(){ return "HelloPost"; }

    /**
     * Implements delete method.
     * @return
     */
    @DeleteMapping("/delete")
    public String DeleteHello(){ return "HelloDelete"; }
}

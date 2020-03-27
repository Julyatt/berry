package com.guosh.servicefeign.controller;

import com.guosh.servicefeign.feign.SchehualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guosh28325
 * @Description
 * @date 2020-03-22 13:57
 */

@RestController
public class HiController {

    @Autowired
    SchehualServiceHi schehualServiceHi;

    public String sayHi(@RequestParam String name) {
        return schehualServiceHi.sayHiFromClientOne(name);
    }
}

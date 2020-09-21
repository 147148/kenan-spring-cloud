package com.jd.kenan.spring.cloud.eureka.producer.controller;

import com.jd.kenan.spring.cloud.core.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "eureka/producer", method = RequestMethod.POST)
public class EurekaProducerController extends BaseController {

    @RequestMapping("execute")
    public String execute(String param) {
        return this.getClass().getPackage() + SPLIT + param;
    }
}

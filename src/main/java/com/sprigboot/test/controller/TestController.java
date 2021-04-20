package com.sprigboot.test.controller;

import com.sprigboot.test.service.RunshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scriptName/",produces = "application/json;charset=UTF-8")
public class TestController {

    //http://134.84.67.31:18080/scriptName/syn_moni
    //http://134.64.12.10:18080/scriptName/get_clzxtable
    @Autowired
    RunshService runshService;

    @GetMapping({"/{system}"})
    public String test(@PathVariable("system") String system) {
        String result = this.runshService.runShBySystem(system);
        return result;
    }


}

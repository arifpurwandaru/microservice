package com.mitrais.scrummit.a;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Athing;

@RestController
public class SimpleController {


    
    @RequestMapping(value="/simpleService", method=RequestMethod.GET)
    public @ResponseBody Athing simpleServ(){
    	return new Athing("SD9393RSF", "This is Simple Service");
    }
    
}

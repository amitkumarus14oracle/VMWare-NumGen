package com.vmware.numbergenerator.controller;

import com.vmware.numbergenerator.service.NumGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class NumGenController {

    @Autowired
    private NumGenService service;

    @RequestMapping(method = RequestMethod.POST, value = "/generate")
    public ResponseEntity generate(@RequestBody Map<String, Integer> body) {
        System.out.println(body.get("step"));
        return ResponseEntity.accepted().body(service.generate(body.get("goal"), body.get("step")));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{uuid}/status")
    public ResponseEntity status(@PathVariable UUID uuid) {
        return ResponseEntity.ok(service.status(uuid));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tasks/{uuid}")
    public ResponseEntity status(@PathVariable UUID uuid, @RequestParam(value = "action", required = true) String action) {
        if(action.equals("get_numlist")) {
            return ResponseEntity.ok(service.getActionList(uuid));
        }
        return ResponseEntity.ok(service.status(uuid));
    }
}

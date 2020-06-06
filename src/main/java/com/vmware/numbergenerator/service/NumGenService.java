package com.vmware.numbergenerator.service;

import com.fasterxml.uuid.Generators;
import com.vmware.numbergenerator.model.GeneratedNumber;
import com.vmware.numbergenerator.repository.NumGenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class NumGenService {

    @Autowired
    private NumGenRepository repository;

    public UUID generate(Integer goal, Integer step) {
        String result = "";
        int i;
        for(i=goal; i>0+step-1; i=i-step) {
            result += i+",";
        }
        result += i;
        //System.out.println(result);
        UUID uuid = Generators.timeBasedGenerator().generate();
        GeneratedNumber num = new GeneratedNumber(uuid, result);
        repository.save(num);
        return uuid;
    }


    public String status(UUID uuid) {
        Optional<GeneratedNumber> opt = repository.findById(uuid);
        if (opt != null) {
            return "SUCCESS";
        }
        return "Either task is in progress or task doesn't exist, try after sometime later";
    }

    public String getActionList(UUID uuid) {
        return null;
    }
}

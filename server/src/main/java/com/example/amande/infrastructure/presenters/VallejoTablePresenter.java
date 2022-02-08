package com.example.amande.infrastructure.presenters;

import com.example.amande.usecase.VallejoTableGetOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

@Component
public class VallejoTablePresenter implements IVallejoTablePresenter {
    
     public String toJson(VallejoTableGetOutput output) {

        String result = null;

        try {

            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(output);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return result;

     }
}

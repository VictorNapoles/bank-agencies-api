package com.bank.agencies.endpoint.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bank.agencies.domain.AgencyGatewayResponse;
import com.bank.agencies.domain.AgencyResponse;

public class AgencyResponseHelper {
    
    public static List<AgencyResponse> getAllAgenciesResponse(List<AgencyGatewayResponse> agencies){
        List<AgencyResponse> agencyResponse = agencies.stream()
            .map(agencyGateway -> AgencyResponse.AgencyResponseBuilder.anAgencyResponse()
            .bank(agencyGateway.getBank())
            .city(agencyGateway.getCity())
            .name(agencyGateway.getName())
            .state(agencyGateway.getState()).build())
            .collect(Collectors.toList());

            return agencyResponse;
    }
    
    public static Map<String, List<AgencyResponse>> getAllAgenciesByStateResponse(List<AgencyGatewayResponse> agencies){
        Map<String,List<AgencyResponse>> agencyResponse = new HashMap<>();
        
        agencies.stream()
        .forEach(agencyGateway -> {
            
            List<AgencyResponse> agencyiesByState = agencyResponse.get(agencyGateway.getState());
            
            if(agencyiesByState == null){
                agencyiesByState = new ArrayList<>();
            }
            
            agencyiesByState.add(AgencyResponse.AgencyResponseBuilder.anAgencyResponse()
            .bank(agencyGateway.getBank())
            .city(agencyGateway.getCity())
            .name(agencyGateway.getName()).build());
            
            agencyiesByState = agencyiesByState.stream().sorted((a, b) ->{
                return a.getName().compareTo(b.getName());
            }).collect(Collectors.toList());
            
            agencyResponse.put(agencyGateway.getState(), agencyiesByState);
        });  
        
        return agencyResponse;
    }
        
}
    
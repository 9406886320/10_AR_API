package com.primesoft.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.primesoft.binding.CitizenApp;
import com.primesoft.entity.CitizenAppEntity;
import com.primesoft.repo.CitizenAppRepository;

@Service
public class ArServiceImpl implements ArService{
	
	@Autowired
	private CitizenAppRepository appRepo;

	@Override
	public Integer createApplication(CitizenApp app) {
		
		//make rest call to ssa-web api with ssn as input (Third party api)
		
		
		String endpointUrl = "http://localhost:9099/plans";
	
		
		RestTemplate rt= new RestTemplate();
			
		ResponseEntity<String> resEntity=
			rt.getForEntity(endpointUrl, String.class);
			
		String stateName =resEntity.getBody();
		
	/*	
		
		WebClient webClient = WebClient.create();
		
		String stateName = webClient.get() //it represents GET request
				            .uri(endpointUrl,app.getSsn())// it represents uri to send
				            .retrieve()//to retrieve response
				            .bodyToMono(String.class)//to specify response type
				            .block(); //to make synchronus call
		
		
		if("New Jersey".equals(stateName)) {
			
			
			CitizenAppEntity entity = new CitizenAppEntity();
			BeanUtils.copyProperties(app, entity);
			
			entity.setStateName(stateName);
			CitizenAppEntity save=appRepo.save(entity);
			
			return save.getAppId();
		}
*/		
		return 0;
	}

	
	
	
	

}

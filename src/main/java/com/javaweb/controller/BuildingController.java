package com.javaweb.controller;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.Service.BuildingService;
import com.javaweb.Service.Impl.BuildingServiceImpl;
import com.javaweb.Service.emyeuanh.BuildingEmyeuanh;
import com.javaweb.model.BuildingModel;

public class BuildingController {
	private BuildingService buildingService = new BuildingServiceImpl() ;
	
	public List<BuildingModel> findBuilding(BuildingModel buildingSearch) {
		List<BuildingModel> results = new ArrayList<>();
		List<BuildingEmyeuanh> emyeuanhs= buildingService.findBuilding(buildingSearch);
		
		for (BuildingEmyeuanh emyeuanh : emyeuanhs) {
			BuildingModel buildingModel = new BuildingModel();
			buildingModel.setName(emyeuanh.getName()+" ");
			buildingModel.setAddress(emyeuanh.getStreet()+" "+emyeuanh.getWard()+" "+emyeuanh.getDistrict());
			results.add(buildingModel);
		}
		return results;
	}

}
	
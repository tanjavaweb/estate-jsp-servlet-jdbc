package com.javaweb.view;

import com.javaweb.controller.BuildingController;
import com.javaweb.dto.BuildingDTO;

public class BuildingEditView {
	
	private static BuildingController buildingController =  new BuildingController();
	public static void main(String[] args) {
		BuildingDTO newBuilding = new BuildingDTO();
		buildingController.insert(newBuilding);
		
	}

}

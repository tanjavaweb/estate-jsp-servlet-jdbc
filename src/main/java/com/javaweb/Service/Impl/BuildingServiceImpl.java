package com.javaweb.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.Service.BuildingService;
import com.javaweb.dao.BuildingDao;
import com.javaweb.dao.Impl.BuildingDaoImpl;
import com.javaweb.dto.BuildingDTO;
import com.javaweb.input.BuildingSearchInput;
import com.javaweb.output.BuildingOutput;

public class BuildingServiceImpl implements BuildingService {

	private BuildingDao buildingDao = new BuildingDaoImpl();

	@Override
	public List<BuildingOutput> findBuilding(BuildingSearchInput buildingModel) {
		List<BuildingOutput> buildingOutput = new ArrayList<>();
		List<BuildingDTO> buildingDTO = buildingDao.findBuilding(buildingModel.getFloorArea(),
				buildingModel.getName(), buildingModel.getWard(), buildingModel.getStreet(),
				buildingModel.getDistrict());
		for (BuildingDTO item : buildingDTO) {
			BuildingOutput building = new BuildingOutput();
			building.setName(item.getName());
			building.setType(item.getType());
			building.setAddress(item.getStreet()+" "+item.getWard()+" "+item.getDistrict());
			buildingOutput.add(building);
		}
		return buildingOutput;
	}

}

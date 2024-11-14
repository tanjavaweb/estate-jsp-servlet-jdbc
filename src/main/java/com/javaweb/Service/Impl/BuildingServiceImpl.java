package com.javaweb.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.javaweb.Service.BuildingService;
import com.javaweb.Service.emyeuanh.BuildingEmyeuanh;
import com.javaweb.dao.BuildingDao;
import com.javaweb.dao.Impl.BuildingDaoImpl;
import com.javaweb.dao.anhyeuem.BuildingAnhyeuem;
import com.javaweb.model.BuildingModel;

public class BuildingServiceImpl implements BuildingService {

	private BuildingDao buildingDao = new BuildingDaoImpl();

	@Override
	public List<BuildingEmyeuanh> findBuilding(BuildingModel buildingModel) {
		List<BuildingEmyeuanh> emyeuanhs = new ArrayList<>();
		List<BuildingAnhyeuem> anhyeuems = buildingDao.findBuilding(buildingModel.getFloorArea(),
				buildingModel.getName(), buildingModel.getWard(), buildingModel.getStreet(),
				buildingModel.getDistrict());
		for (BuildingAnhyeuem item : anhyeuems) {
			BuildingEmyeuanh emyeuanh = new BuildingEmyeuanh();
			emyeuanh.setDistrict(item.getDistrict());
			emyeuanh.setFloorArea(item.getFloorArea());
			emyeuanh.setName(item.getName());
			emyeuanh.setWard(item.getWard());
			emyeuanh.setStreet(item.getStreet());
			emyeuanhs.add(emyeuanh);
		}
		return emyeuanhs;
	}

}

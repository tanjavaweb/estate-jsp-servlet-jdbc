package com.javaweb.view;

import java.util.List;
import java.util.Scanner;

import com.javaweb.controller.BuildingController;
import com.javaweb.input.BuildingSearchInput;
import com.javaweb.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		
		String name = null;
		String street = null;
		String district = null;
		String ward = null;
		Integer floorArea = null;
//		Integer numberOfBasement = null;
//		String typeBuilding = null;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter street: ");
		street = input.nextLine();
		System.out.print("Enter district: ");
		district = input.nextLine();
		System.out.print("Enter ward: ");
		ward = input.nextLine();
		System.out.print("Enter floorArea: ");
		while (true) {
			String line = input.nextLine();
			if (line.isEmpty()) {
				break;
			}

			try {
				floorArea = Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
			}
		}
		
//		System.out.println("Enter numberOfBasement: ");
//		while (true) {
//			String line = input.nextLine();
//			if (line.isEmpty()) {
//				break;
//			}
//
//			try {
//				numberOfBasement = Integer.parseInt(line);
//			} catch (NumberFormatException e) {
//				System.out.println("Vui lòng nhập một số nguyên hợp lệ.");
//			}
//		}
//		System.out.print("Enter type building: ");
//		typeBuilding = input.nextLine();

		input.close();
		BuildingSearchInput buildingSearch = new BuildingSearchInput();
		buildingSearch.setFloorArea(floorArea);
		buildingSearch.setName(name);
		buildingSearch.setWard(ward);
		buildingSearch.setStreet(street);
		buildingSearch.setDistrict(district);
		
		BuildingController buildingController = new BuildingController();
		List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
		System.out.println("");
		for (BuildingOutput building: buildings) {
			System.out.println(building.getName()+" "+building.getType()+" "+building.getAddress());
		}
	}

}

//Norch tầng trệt nguyên căn  170 Bùi Thị Xuân Phạm Ngũ Lão Quận 1
//Bảo Việt Building tầng trệt nguyên căn nội thất  233 Đồng Khởi Bến Nghé Quận 1
//Vincom Landmark 81 tầng trệt nguyên căn nội thất  720A Điện Biên Phủ 22 Quận Bình Thạnh
//Hạnh Phúc Building tầng trệt  55 Cách Mạng Tháng Tám An Hòa Ninh Kiều


package com.javaweb.oop;

public class CaChuon  extends LopCa {
	private String colorEye;
	private String colorSkin;
	public CaChuon() {
		super.colorEye = "coloEye";
		super.colorSkin = "colorSkin";
	}
	
		
	public CaChuon(String coloEye, String colorSkin) {
		super();
		this.colorEye = coloEye;
		this.colorSkin = colorSkin;
	}


	public CaChuon(String colorEye, String colorSkin, String colorParentEye, String colorParentSkin) {
	this.colorEye=colorEye;
	this.colorSkin=colorSkin;
	super.colorEye=colorParentEye;
	super.colorSkin=colorParentSkin;
	}

	public String getColoEye() {
		return colorEye;
	}

	public void setColoEye(String coloEye) {
		this.colorEye = coloEye;
	}

	public String getColorSkin() {
		return colorSkin;
	}

	public void setColorSkin(String colorSkin) {
		this.colorSkin = colorSkin;
	}
	public void setParentColorEye(String colorParentEye) {
		super.colorEye = colorParentEye;
		
	}
	public String getParentColorEye() {
		return super.colorEye;
		
	}
	
}

package players;

import java.util.ArrayList;


import entity.Kingdom;
import entity.Residence;
import entity.Town;

public class HumanUser {

	private ArrayList<Kingdom> userDistricts = new ArrayList<Kingdom>();
	private String userName;
	private Integer totalNumberOfPoint;

	
	
	public HumanUser(){
		Town town1 = new Town("Craiova",5);
	
		Town town2 = new Town("Ploiesti",5);
		Town town3 = new Town("Sibiu",5);
		Residence residence1 = new Residence("PrahovaResidence",10);
		Residence residence2 = new Residence("BrasovResidence",10);
		Residence residence3 = new Residence("BuzauResidence",10);
		Residence residence4 = new Residence("IalomitaResidence",10);
		userDistricts.add(town1);
		userDistricts.add(town2);
		userDistricts.add(town3);
		userDistricts.add(residence1);
		userDistricts.add(residence2);
		userDistricts.add(residence3);
		userDistricts.add(residence4);
		
		
	}
	
	public HumanUser(String userName){
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<Kingdom> getUserDistricts() {
		return userDistricts;
	}
	public Integer getTotalNumberOfPoint() {
		return totalNumberOfPoint;
	}
	public void setTotalNumberOfPoint(Integer totalNumberOfPoint) {
		this.totalNumberOfPoint = totalNumberOfPoint;
	}
	public void setUserDistricts(ArrayList<Kingdom> userDistricts) {
		this.userDistricts = userDistricts;
	}
	@Override
	public String toString() {
		return "HumanUser name is: userName ";
	}
	
	



	
	
	
}

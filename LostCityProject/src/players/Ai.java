package players;

import java.util.ArrayList;


import entity.Kingdom;
import entity.Residence;
import entity.Town;

public class Ai {

	private ArrayList<Kingdom> aiDistricts = new ArrayList<Kingdom>();
	private final String AI_NAME = "AI";
	private Integer totalNumberOfPoint;
	Kingdom district;
	
	
	public Ai(){
	Town town1 = new Town("Arad",5);
	Town town2 = new Town("Timisoara",5);
	Town town3 = new Town("Hunedoara",5);
	Residence residence1 = new Residence("TimisResidence",10);
	Residence residence2 = new Residence("AradResidence",10);
	Residence residence3 = new Residence("HunedoaraResidence",10);
	Residence residence4 = new Residence("AlbaResidence",10);
	aiDistricts.add(town1);
	aiDistricts.add(town2);
	aiDistricts.add(town3);
	aiDistricts.add(residence1);
	aiDistricts.add(residence2);
	aiDistricts.add(residence3);
	aiDistricts.add(residence4);
	}

	public ArrayList<Kingdom> getAiDistricts() {
		return aiDistricts;
	}

	public void setAiDistricts(ArrayList<Kingdom> aiDistricts) {
		this.aiDistricts = aiDistricts;
	}

	public Integer getTotalNumberOfPoint() {
		return totalNumberOfPoint;
	}

	public void setTotalNumberOfPoint(Integer totalNumberOfPoint) {
		this.totalNumberOfPoint = totalNumberOfPoint;
	}

	public String getAI_NAME() {
		return AI_NAME;
	}

	@Override
	public String toString() {
		return "Ai [AI_NAME=" + AI_NAME + "]";
	}
	


}

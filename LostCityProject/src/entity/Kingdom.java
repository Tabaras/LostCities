package entity;

public class Kingdom {
	
	private String name;
	private Integer numberOfPoints;
	
	public Kingdom(){
		
	}
	public Kingdom(String name, Integer numberOfPoints) {
		super();
		this.name = name;
		this.numberOfPoints = numberOfPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfPoints() {
		return numberOfPoints;
	}

	public void setNumberOfPoints(Integer numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
	}
	

	@Override
	public String toString() {
		return "District [name=" + name + ", numberOfPoints=" + numberOfPoints + "]";
	}
	
		
		
	
	
	
	
}

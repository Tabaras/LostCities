package entity;

import java.util.Comparator;

public class CompareClass implements Comparator<Kingdom>{

	@Override
	public int compare(Kingdom d1, Kingdom d2) {
		
		return d1.getName().compareTo(d2.getName());
	}

}

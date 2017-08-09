package service;

import java.util.List;
import model.*;

public interface DataService {
	
	public boolean addEntity(Javascript item);
	public Javascript getEntityByName(String name);
	public List<Javascript> getEntityList();

}

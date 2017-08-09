package dao;

import java.util.List;
import model.*;

public interface DataDao {
	
	public boolean addEntity(Javascript item);
	public Javascript getEntityByName(String name);
	public List<Javascript> getEntityList();
	}

package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dao.*;
import model.*;

public class DataServiceImpl implements DataService{

	@Autowired
	private DataDao dataDao;
	

	public void setDataDao(DataDao dataDao) {
		this.dataDao = dataDao;
	}
	
	@Override
	public boolean addEntity(Javascript item) {
		return dataDao.addEntity(item);
	}


	@Override
	public Javascript getEntityByName(String name) {
		return dataDao.getEntityByName(name);
	}

	@Override
	public List<Javascript> getEntityList() {
		return dataDao.getEntityList();
	}

}

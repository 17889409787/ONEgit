package com.iuexam.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.iuexam.dao.ManagerMapper;
import com.iuexam.entity.Manager;
import com.iuexam.service.IManagerService;

/**
 * 
 * 管理员Service接口实现类
 *
 */
@Service
public class ManagerServiceImp implements IManagerService {
	@Autowired
	private ManagerMapper managerDao;
	public Manager getManager(String managerid, String pwd) {
		Manager manager=managerDao.getManager(managerid);
		
		if(manager!=null) {
			if(manager.getPwd().equals(pwd))
				return manager;
		}
		return null;
	}
	public boolean update(Manager manager) {
		return managerDao.update(manager);
		
	}
	public Manager getbyid(String managerid) {
		// TODO Auto-generated method stub
		return managerDao.getbyid(managerid);
	}


	public Manager getmanager(String managerid) {
		// TODO Auto-generated method stub
		return null;
	}
	public Manager getbyid(String managerid, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}


}

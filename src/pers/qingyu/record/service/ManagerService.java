package pers.qingyu.record.service;

import pers.qingyu.record.dao.ManagerDao;
import pers.qingyu.record.po.SystemManager;

public class ManagerService {
	public SystemManager getManager(String id) {
		ManagerDao dao = new ManagerDao();
		return dao.loadManager(id);
	}
}

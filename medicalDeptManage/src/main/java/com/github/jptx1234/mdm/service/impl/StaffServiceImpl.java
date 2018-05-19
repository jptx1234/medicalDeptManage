package com.github.jptx1234.mdm.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.StaffMapper;
import com.github.jptx1234.mdm.model.Staff;
import com.github.jptx1234.mdm.service.StaffService;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffMapper staffMapper;

	@Override
	public Staff getStaffListByCond(String staffName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStaff(Staff staff) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStaff(Staff staff) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStaff(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Staff getPwdByEName(String staffename) {
		// TODO Auto-generated method stub
		return staffMapper.getPasswordByEname(staffename);
	}

}

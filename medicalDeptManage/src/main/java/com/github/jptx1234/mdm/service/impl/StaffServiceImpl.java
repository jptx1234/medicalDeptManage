package com.github.jptx1234.mdm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jptx1234.mdm.dao.StaffMapper;
import com.github.jptx1234.mdm.model.Staff;
import com.github.jptx1234.mdm.model.StaffExample;
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
	public int insertStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffMapper.insert(staff);
	}

	@Override
	public void updateStaff(Staff staff) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStaff(Integer id) {
		// TODO Auto-generated method stub
		staffMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Staff getPwdByEName(String staffename) {
		// TODO Auto-generated method stub
		return staffMapper.getPasswordByEname(staffename);
	}

	@Override
	public int countByExample(StaffExample example) {
		// TODO Auto-generated method stub
		return staffMapper.countByExample(example);
	}

	@Override
	public List<Staff> selectByExample(StaffExample example) {
		// TODO Auto-generated method stub
		return staffMapper.selectByExample(example);
	}

}

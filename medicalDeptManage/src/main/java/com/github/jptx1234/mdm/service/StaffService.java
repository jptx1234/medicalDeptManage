package com.github.jptx1234.mdm.service;

import java.util.List;

import com.github.jptx1234.mdm.model.Staff;
import com.github.jptx1234.mdm.model.StaffExample;

public interface StaffService {
	
	public Staff getStaffListByCond(String staffName);
	
	public int insertStaff(Staff staff);
	
	public void updateStaff(Staff staff);
	
	public void deleteStaff(Integer id);
	
	public Staff getPwdByEName(String staffename);
	
	public int countByExample(StaffExample example);
	
	public List<Staff> selectByExample(StaffExample example);

}

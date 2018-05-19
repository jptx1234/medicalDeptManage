package com.github.jptx1234.mdm.service;

import java.util.Map;

import com.github.jptx1234.mdm.model.Staff;

public interface StaffService {
	
	public Staff getStaffListByCond(String staffName);
	
	public void insertStaff(Staff staff);
	
	public void updateStaff(Staff staff);
	
	public void deleteStaff(Integer id);
	
	public Staff getPwdByEName(String staffename);

}

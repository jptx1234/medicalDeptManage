package com.github.jptx1234.mdm.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 物品包实例
 *
 */
public class StuffPackDecompose implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer packTypeId;
	private String packTypeName;
	private String packName;
	private String packDesc;
	private String packImg;
	private String state = "1";//1有效，0无效
	private Date createDate;
	private Date stateDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPackTypeId() {
		return packTypeId;
	}
	public void setPackTypeId(Integer packTypeId) {
		this.packTypeId = packTypeId;
	}
	public String getPackTypeName() {
		return packTypeName;
	}
	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getPackDesc() {
		return packDesc;
	}
	public void setPackDesc(String packDesc) {
		this.packDesc = packDesc;
	}
	public String getPackImg() {
		return packImg;
	}
	public void setPackImg(String packImg) {
		this.packImg = packImg;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getStateDate() {
		return stateDate;
	}
	public void setStateDate(Date stateDate) {
		this.stateDate = stateDate;
	}
	@Override
	public String toString() {
		return "StuffPack [id=" + id + ", packTypeId=" + packTypeId + ", packTypeName=" + packTypeName + ", packName="
				+ packName + ", packDesc=" + packDesc + ", packImg=" + packImg + ", state=" + state + ", createDate="
				+ createDate + ", stateDate=" + stateDate + "]";
	}
	

}

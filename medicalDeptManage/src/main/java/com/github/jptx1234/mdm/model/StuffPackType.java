package com.github.jptx1234.mdm.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 物品包类别
 *
 */
public class StuffPackType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String packTypeName;
	private String packTypeDesc;
	private String packTypeImg;
	private String state = "1";//1有效，0无效
	private Date createDate;
	private Date stateDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPackTypeName() {
		return packTypeName;
	}
	public void setPackTypeName(String packTypeName) {
		this.packTypeName = packTypeName;
	}
	public String getPackTypeDesc() {
		return packTypeDesc;
	}
	public void setPackTypeDesc(String packTypeDesc) {
		this.packTypeDesc = packTypeDesc;
	}
	public String getPackTypeImg() {
		return packTypeImg;
	}
	public void setPackTypeImg(String packTypeImg) {
		this.packTypeImg = packTypeImg;
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
	
	

}

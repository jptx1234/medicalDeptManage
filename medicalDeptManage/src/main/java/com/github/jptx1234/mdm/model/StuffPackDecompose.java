package com.github.jptx1234.mdm.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 物品包分解实例
 *
 */
public class StuffPackDecompose implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer packId;
	private String packName;
	private String decomposeName;
	private String decomposeDesc;
	private String decomposeImg;
	private String state = "1";//1有效，0无效
	private Date createDate;
	private Date stateDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getState() {
		return state;
	}
	public Integer getPackId() {
		return packId;
	}
	public void setPackId(Integer packId) {
		this.packId = packId;
	}
	public String getDecomposeName() {
		return decomposeName;
	}
	public void setDecomposeName(String decomposeName) {
		this.decomposeName = decomposeName;
	}
	public String getDecomposeDesc() {
		return decomposeDesc;
	}
	public void setDecomposeDesc(String decomposeDesc) {
		this.decomposeDesc = decomposeDesc;
	}
	public String getDecomposeImg() {
		return decomposeImg;
	}
	public void setDecomposeImg(String decomposeImg) {
		this.decomposeImg = decomposeImg;
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
		return "StuffPackDecompose [id=" + id + ", packId=" + packId + ", packName=" + packName + ", decomposeName="
				+ decomposeName + ", decomposeDesc=" + decomposeDesc + ", decomposeImg=" + decomposeImg + ", state="
				+ state + ", createDate=" + createDate + ", stateDate=" + stateDate + "]";
	}
	

}

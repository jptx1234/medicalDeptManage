package com.github.jptx1234.mdm.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 文档类别
 *
 */
public class DocType implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String doc_type_name;
	private String doc_type_desc;
	private String doc_type_img;
	private String state;
	private Date create_date;
	private Date state_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDoc_type_name() {
		return doc_type_name;
	}
	public void setDoc_type_name(String doc_type_name) {
		this.doc_type_name = doc_type_name;
	}
	public String getDoc_type_desc() {
		return doc_type_desc;
	}
	public void setDoc_type_desc(String doc_type_desc) {
		this.doc_type_desc = doc_type_desc;
	}
	public String getDoc_type_img() {
		return doc_type_img;
	}
	public void setDoc_type_img(String doc_type_img) {
		this.doc_type_img = doc_type_img;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getState_date() {
		return state_date;
	}
	public void setState_date(Date state_date) {
		this.state_date = state_date;
	}
	@Override
	public String toString() {
		return "DocType [id=" + id + ", doc_type_name=" + doc_type_name + ", doc_type_desc=" + doc_type_desc
				+ ", doc_type_img=" + doc_type_img + ", state=" + state + ", create_date=" + create_date
				+ ", state_date=" + state_date + "]";
	}
	
	

}

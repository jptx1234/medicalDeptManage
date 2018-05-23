package com.github.jptx1234.mdm.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 文档实例
 *
 */
public class DocInstance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer doc_type_id;
	private String doc_type_name;
	private String doc_name;
	private String doc_desc;
	private String doc_author;
	private String doc_path;
	private String doc_html;
	private String is_html;
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
	public Integer getDoc_type_id() {
		return doc_type_id;
	}
	public void setDoc_type_id(Integer doc_type_id) {
		this.doc_type_id = doc_type_id;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getDoc_desc() {
		return doc_desc;
	}
	public void setDoc_desc(String doc_desc) {
		this.doc_desc = doc_desc;
	}
	public String getDoc_author() {
		return doc_author;
	}
	public void setDoc_author(String doc_author) {
		this.doc_author = doc_author;
	}
	public String getDoc_path() {
		return doc_path;
	}
	public void setDoc_path(String doc_path) {
		this.doc_path = doc_path;
	}
	public String getDoc_html() {
		return doc_html;
	}
	public void setDoc_html(String doc_html) {
		this.doc_html = doc_html;
	}
	public String getIs_html() {
		return is_html;
	}
	public void setIs_html(String is_html) {
		this.is_html = is_html;
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
		return "DocInstance [id=" + id + ", doc_type_id=" + doc_type_id + ", doc_type_name=" + doc_type_name
				+ ", doc_name=" + doc_name + ", doc_desc=" + doc_desc + ", doc_author=" + doc_author + ", doc_path="
				+ doc_path + ", doc_html=" + doc_html + ", is_html=" + is_html + ", state=" + state + ", create_date="
				+ create_date + ", state_date=" + state_date + "]";
	}
	
	

}

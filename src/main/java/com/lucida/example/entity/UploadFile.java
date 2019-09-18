package com.lucida.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "uploadtable")

public class UploadFile {
	
		public UploadFile(int id, String filename, String path, String filetype, String uploadedby, Date uploaded_on) {
		super();
		this.id = id;
		this.filename = filename;
		this.path = path;
		this.filetype = filetype;
		this.uploadedby = uploadedby;
		this.uploaded_on = uploaded_on;
	}
		public UploadFile() {
			// TODO Auto-generated constructor stub
		}
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getUploadedby() {
		return uploadedby;
	}
	public void setUploadedby(String uploadedby) {
		this.uploadedby = uploadedby;
	}
	public Date getUploaded_on() {
		return uploaded_on;
	}
	public void setUploaded_on(Date uploaded_on) {
		this.uploaded_on = uploaded_on;
	}
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column
		private String filename;
		@Column
		private String path;
		@Column
		private String filetype;
		@Column
		private String uploadedby;
		@Column
		private Date uploaded_on;

		

		
}

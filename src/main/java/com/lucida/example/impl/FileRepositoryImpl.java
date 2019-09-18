package com.lucida.example.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.lucida.example.entity.UploadFile;
import com.lucida.example.service.FileStorageService;

@Repository
public class FileRepositoryImpl {

	

		@Autowired
		private FileStorageService fileStorageService;
		@Autowired
		private JdbcTemplate jdbcTemplate;

		public void save(MultipartFile file, String uploadedby) {
			String Sql = "INSERT INTO uploadtable"
					+ "(id, filename, path, filetype, uploadedby, uploaded_on) VALUES (0, ?, ?, ?, ?, ?)";
			
			
			
			String fileName = fileStorageService.storeFile(file);
			String path="C:/Users/Rashmi/Desktop/hebbar"+fileName;
//	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
//					.path(fileName).toUriString();
			LocalDate uploadeddate = LocalDate.now();
			this.jdbcTemplate.update(Sql, new Object[] { file.getOriginalFilename(), path, file.getContentType(),
					uploadedby, uploadeddate });
		}
			public List<UploadFile> findbyfilename(String filename){
			String sql = "SELECT * FROM uploadtable where filename = '" + filename + "' ";

			List<UploadFile> uploadFile = this.jdbcTemplate.query(sql, new RowMapper<UploadFile>() {
				@Override
				public UploadFile mapRow(ResultSet rs, int rownumber) throws SQLException {
					UploadFile upload = new UploadFile();
					upload.setId(rs.getInt(1));
					upload.setFilename(rs.getString(2));
					upload.setFiletype(rs.getString(3));
					upload.setPath(rs.getString(4));
					upload.setUploaded_on(rs.getDate(5));
					upload.setUploadedby(rs.getString(6));

					return upload;
				}
			});
			return uploadFile;
		}
			

	}

	


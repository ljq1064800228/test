package com.ak1ak1.service;

import org.springframework.web.multipart.MultipartFile;

import com.ak1ak1.entity.query.PicUploadResult;

public interface FileService {

	PicUploadResult upload(MultipartFile uploadFile);

}

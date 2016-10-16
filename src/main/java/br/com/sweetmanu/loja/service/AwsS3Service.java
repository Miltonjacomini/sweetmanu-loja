package br.com.sweetmanu.loja.service;

import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.model.S3Object;

public interface AwsS3Service {

	public S3Object uploadFile(MultipartFile file, String fileName);
	
}

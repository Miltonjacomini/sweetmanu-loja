package br.com.sweetmanu.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import br.com.sweetmanu.service.AwsS3Service;

@Service
public class AwsS3ServiceImpl implements AwsS3Service {

	@Autowired
	private AmazonS3 s3Client;

	private String nameBucket = System.getenv("AWS_BUCKET_NAME");

	public S3Object uploadFile(MultipartFile file, String fileName) {

		try {
		
			InputStream is;
			is = file.getInputStream();

			s3Client.putObject(new PutObjectRequest(nameBucket, fileName, is, new ObjectMetadata())
					.withCannedAcl(CannedAccessControlList.PublicRead));

			S3Object s3object = s3Client.getObject(new GetObjectRequest(nameBucket, fileName));
			
			return s3object;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}

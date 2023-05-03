package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import jakarta.annotation.*;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

//객체 생성/ 수정/ 삭제 코드 참고
//https://docs.aws.amazon.com/ko_kr/sdk-for-java/latest/developer-guide/examples-s3-objects.html

@Controller
@RequestMapping("sub32")
public class Controller32 {
	
	@Value("${aws.accessKeyId}")
	String accessKey;
	
	@Value("${aws.secretAccessKeyId}")
	String secretKey;
	
	@Value("${aws.s3.bucketName}")
	String bucketName;
	
	private S3Client s3;
	
	@PostConstruct
	public void init() {
		AwsCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
		AwsCredentialsProvider provider = StaticCredentialsProvider.create(credentials);
		Region region = Region.AP_NORTHEAST_2;

		this.s3 = S3Client.builder()
				.credentialsProvider(provider)
				.region(region)
				.build();

	}
	
	@GetMapping("link1")
	public void method1() {
		System.out.println(accessKey);
		System.out.println(secretKey);

		String key = "test/젤리.txt";

		String content = "새로운 파일 내용물";

		// s3에 파일 업로드
		PutObjectRequest objectRequest = PutObjectRequest.builder()
				.bucket(bucketName)
				.acl(ObjectCannedACL.PUBLIC_READ)
				.key(key)
				.build();

		s3.putObject(objectRequest, RequestBody.fromBytes(content.getBytes()));
	}

	@GetMapping("link2")
	public void method2() {
		String key = "test/젤리.jpg";
		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
				.bucket(bucketName)
				.key(key)
				.build();

		s3.deleteObject(deleteObjectRequest);
	}
	
	@GetMapping("link3")
	public void method03() {
		// 파일 업로드 가능한 폼 있는 뷰로 포워드
		
	}
	
	@PostMapping("link4")
	public void method04(@RequestParam("files") MultipartFile[] files) throws Exception{
		//aws s3 내 버킷의 test 폴더로 업로드
		for(MultipartFile file : files) {
			
			if(file.getSize() > 0) {
				String key = "test/" + file.getOriginalFilename();				
				PutObjectRequest por = PutObjectRequest.builder()
													   .key(key)
													   .acl(ObjectCannedACL.PUBLIC_READ)
													   .bucket(bucketName)
													   .build();
				
				s3.putObject(por, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
			}
		}
	}
	
	@PostMapping("link5")
	public void method05(String fileName) {
		String key = "test/" + fileName;
		
		DeleteObjectRequest dor = DeleteObjectRequest.builder()
													 .key(key)
													 .bucket(bucketName)
													 .build();
			s3.deleteObject(dor);
													 
	}
	
	
	
	
}

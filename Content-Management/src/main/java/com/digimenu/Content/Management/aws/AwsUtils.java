package com.digimenu.Content.Management.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.IOException;
import java.io.InputStream;

public class AwsUtils {

    public AWSCredentials awsCredentials(String accessKey , String secretKey){
        return new BasicAWSCredentials(
                accessKey,
                secretKey
        );
    }


    public AmazonS3 awsS3ClientBuilder(String accessKey , String secretKey){
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials(accessKey,secretKey)))
                .withRegion(Regions.EU_NORTH_1)
                .build();
    }


    public String uploadFileToS3(String fileName , InputStream inputStream , String accessKey , String secretKey , String bucketName) throws IOException {

        AmazonS3 s3Client = awsS3ClientBuilder(accessKey,secretKey);

        ObjectMetadata metadata = new ObjectMetadata();
        System.out.println("File Name : " + fileName);
        metadata.setContentType("image.jpeg");
        metadata.setContentLength(inputStream.available());

        PutObjectRequest request = new PutObjectRequest(bucketName,fileName,inputStream,metadata);

        s3Client.putObject(request);

        System.out.println(s3Client.getUrl(bucketName,fileName).toString());
        return s3Client.getUrl(bucketName,fileName).toString();
    }


    public String getContent(String fileName){

        if(fileName.endsWith(".jpeg") || fileName.equals("jpg")){
            return "image.jpeg";
        }else{
            return "image.webp";
        }
    }


    public String downloadFileFromS3(String fileName , String accessKey , String secretKey , String bucketName){
        AmazonS3 amazonS3 = awsS3ClientBuilder(accessKey,secretKey);
        return amazonS3.getUrl(bucketName,fileName).toString();
    }
}


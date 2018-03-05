package com.example.demo;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Controller
public class ProfileController {
	@GetMapping(value="/")
	public ModelAndView renderPage() {
		ModelAndView indexPage = new ModelAndView();
		
		indexPage.setViewName("index");
		return indexPage;
		
	}
	@PostMapping(value="/upload")
	public ModelAndView uploadtoS3(
		@RequestParam("file") MultipartFile image
		){
		ModelAndView profilePage = new ModelAndView();
		BasicAWSCredentials cred = new BasicAWSCredentials("AKIAJM7ON37B2ZY4OS4A","kyw9Ozp4V84KVyyQ82FnHMpcGqS+fmhTOW2B+0Bn");
		AmazonS3 s3client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).withRegion(Regions.US_EAST_2).build();
		try {
			PutObjectRequest putReq = new PutObjectRequest("junebalachandran",image.getOriginalFilename(),image.getInputStream(),new ObjectMetadata()).withCannedAcl(CannedAccessControlList.PublicRead);
			s3client.putObject(putReq);
			String imgSrc = "http://"+"junebalachandran"+".s3.amazonaws.com/"+image.getOriginalFilename();
			profilePage.addObject("imgSrc", imgSrc);
			profilePage.setViewName("profilePage");
			return profilePage;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profilePage.setViewName("index");
		return profilePage;
		
	}
	
}

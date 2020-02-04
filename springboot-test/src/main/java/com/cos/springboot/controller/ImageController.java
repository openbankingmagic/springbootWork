package com.cos.springboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// Controller, Configuration, Repository


@Controller
public class ImageController {
	
	// DI 해주는 방법
	@Value("${file.path}")
	private String fileRealPath;
	
	@PutMapping("/image/upload")
	public @ResponseBody String imageUpload(@RequestParam("imgFile") MultipartFile imgFile) {
		// 1번 imgFile 출력
		
		System.out.println(imgFile.getOriginalFilename());
		System.out.println(imgFile.getContentType());
		System.out.println(imgFile.getSize());
		System.out.println(imgFile.getName());
		System.out.println();
	
		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid+"_"+imgFile.getOriginalFilename();
		
		// 사진 용량이 작으면 비동기 처리 안해도 된다. 
		// 용량이 크면 a싱크로나이즈드 파일채널 해야된다.
		// 강제로 기다리면 된다 스레드로 3초만
		// DB에 uuidFilename 만 저장하면 된다.
		Path filePath = Paths.get(fileRealPath+uuidFilename);
		// 외부에 잡아야 파일들어올때마다 톰갟자구실행되니
		// 메모리와 아이오 통신하니 트라이캐치 필요
		// db에는 파일명만 저장하면 된다.
		try {
			Files.write(filePath, imgFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			for(byte b: imgFile.getBytes()) {
//				System.out.print(b);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return "ok";
	}
}

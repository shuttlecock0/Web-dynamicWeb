package edu.autocar.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SaveImageService {
	private int num = 0;
	
	public void saveImage(int cameraId, MultipartFile image) {
		if(image == null)
			return;
		File file = new File("C:/temp/pi_save_image", Integer.toString(cameraId) + "_" + num + ".jpg");
		System.out.println(num);
		num++;
		try {
			image.transferTo(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

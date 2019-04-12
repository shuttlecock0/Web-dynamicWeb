package edu.autocar.mjpegstream;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.autocar.service.SaveImageService;

@Controller
@Repository
public class CameraController {

	@GetMapping("/monitor")
	public void monitor() {
	}

	@GetMapping("/camera")
	public void camera() {
	}

	@GetMapping("/camera/{cameraId}")
	public String camera(@PathVariable("cameraId") int cameraId, Model model) {
		model.addAttribute("deviceId", cameraId);
		return "camera";
	}

	@Autowired
	MjpegBroker broker;
	
	@Autowired
	SaveImageService service;
	
	@PostMapping("/camera/{cameraId}")
	@ResponseBody
	public boolean postCamera(@PathVariable("cameraId") int cameraId, @RequestParam("image") MultipartFile image) {
		try {
			broker.update(cameraId, image.getBytes());
			service.saveImage(cameraId, image);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@GetMapping("/ipcam") 
	public void ipcam() { 
	}
}

package com.qudi.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qudi.util.MessageUtil;

@Controller
public class FileController {

	/*@GetMapping(value = "/file")
	public String file() {
		return "file";
	}

	@PostMapping(value = "/fileUpload")
	public MessageUtil fileUpload(@RequestParam(value = "file") MultipartFile file, Model model,
			HttpServletRequest request) {
		MessageUtil message = new MessageUtil();
		if (file.isEmpty()) {
			System.out.println("鏂囦欢涓虹┖绌�");
		}
		System.out.println(file);
		String fileName = file.getOriginalFilename(); // 鏂囦欢鍚�
		
		String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 鍚庣紑鍚�
		String filePath = "G://temp-rainy//"; // 涓婁紶鍚庣殑璺緞
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");// 璁剧疆鏃ユ湡鏍煎紡

		fileName = UUID.randomUUID() + "qudian_img-1-" + df.format(new Date()).toString() + suffixName; // 鏂版枃浠跺悕
		File dest = new File(filePath + fileName);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String filename = "/temp-rainy/" + fileName;
		model.addAttribute("filename", filename);
		return message;

	}*/

}
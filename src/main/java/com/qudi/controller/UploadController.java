package com.qudi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;*/

/*import com.qudi.util.MessageUtil;
import com.qudi.util.Result;*/

@RestController
@SpringBootApplication
@RequestMapping("/upload")
public class UploadController {

	private String file;

	/**
	 * 图片上传
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
/*	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public @ResponseBody MessageUtil uploadImg(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MessageUtil message = new MessageUtil();
		file = req.getParameter("file");
		if (file != null) {

			byte[] b = Base64Coder.decodeLines(file);
			String filepath = req.getSession().getServletContext().getRealPath("/files");
			File file = new File(filepath);
			if (!file.exists())
				file.mkdirs();
			FileOutputStream fos = new FileOutputStream(
					file.getPath() + "/image" + (int) (Math.random() * 100) + ".bmp");
			System.out.println("--------->>....>>>>>" + file.getPath());
			fos.write(b);
			fos.flush();
			fos.close();
			if (file.exists()) {
				message.setResult(Result.SUCCEED);
				message.setInfo("上传成功");
				return message;
			}
			message.setInfo("上传失败");
			return message;
		}
		message.setInfo("参数错误");
		return message;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody MessageUtil delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = req.getParameter("filePath");
		MessageUtil message = new MessageUtil();
		if (path != null) {
			File file = new File(path);
			if (file.exists()) {
				file.delete();
				if (!file.exists()) {
					message.setInfo("文件已删除");
					message.setResult(Result.SUCCEED);
					return message;
				}
				message.setInfo("删除失败");
				return message;
			}
			message.setInfo("文件不存在");
			return message;
		}
		message.setInfo("参数错误");
		return message;
	}*/

}

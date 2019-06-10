package com.qudi.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;

public class Cover8xTo16x {

	public static final String APP_ID = "16341462";
	public static final String API_KEY = "iismEWGGsKZTd1v2Z9PxI2hB";
	public static final String SECRET_KEY = "HuXt0Fpl8z9nc8aXv6AsUicsquDQF8VV";

//	static final Logger logger = LoggerFactory.getLogger(Cover8xTo16x.class);
	/**
	 * 音频文件频率8k转16k。必须要转，因为不转百度识别不出来，错误信息是音质太差
	 * 
	 * @param sourceFile
	 * @return
	 */
	public static File cover8xTo16x(File sourceFile) {
		String targetPath = null;
		try {
			File ffmpegPath = new File("E:\\project\\ffmpeg\\bin\\ffmpeg"); // 存放ffmpeg程序的目录
			targetPath = sourceFile.getAbsolutePath().replaceAll(".wav", "_16x.wav");
			// ffmpeg.exe -i source.wav -ar 16000 target.wav
			List<String> wavToPcm = new ArrayList<String>();
			wavToPcm.add(ffmpegPath.getAbsolutePath());
			wavToPcm.add("-i");
			wavToPcm.add(sourceFile.getAbsolutePath());
			wavToPcm.add("-ar");
			wavToPcm.add("16000");
			wavToPcm.add(targetPath);
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(wavToPcm);
			builder.redirectErrorStream(true);
			Process process = builder.start();
			process.waitFor();
		} catch (Exception e) {
			// logger.error("录音文件8k转化16k失败"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		// if (StringUtils.isNotEmpty(targetPath)) {
		return new File(targetPath);
		// }
		// logger.error("传入的文件路径有误");
		// return null;
	}

	/**
	 * 语音转文字
	 */
	public static void phoneticLiteral(String path, String type) {
		// 参数顺序 APP_ID, API_KEY, SECRET_KEY
		AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		JSONObject res = client.asr(path, type, 16000, null);
		System.out.println(res);

	}

	public static void main(String[] arg) {

		phoneticLiteral("E:\\MyMusic\\许嵩 - 医生.mp3", "mp3");

	}

}

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
	 * ��Ƶ�ļ�Ƶ��8kת16k������Ҫת����Ϊ��ת�ٶ�ʶ�𲻳�����������Ϣ������̫��
	 * 
	 * @param sourceFile
	 * @return
	 */
	public static File cover8xTo16x(File sourceFile) {
		String targetPath = null;
		try {
			File ffmpegPath = new File("E:\\project\\ffmpeg\\bin\\ffmpeg"); // ���ffmpeg�����Ŀ¼
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
			// logger.error("¼���ļ�8kת��16kʧ��"+e.getMessage());
			e.printStackTrace();
			return null;
		}
		// if (StringUtils.isNotEmpty(targetPath)) {
		return new File(targetPath);
		// }
		// logger.error("������ļ�·������");
		// return null;
	}

	/**
	 * ����ת����
	 */
	public static void phoneticLiteral(String path, String type) {
		// ����˳�� APP_ID, API_KEY, SECRET_KEY
		AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);
		JSONObject res = client.asr(path, type, 16000, null);
		System.out.println(res);

	}

	public static void main(String[] arg) {

		phoneticLiteral("E:\\MyMusic\\���� - ҽ��.mp3", "mp3");

	}

}

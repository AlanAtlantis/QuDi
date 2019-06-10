package com.qudi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadFromFile {

	public static void readFile(String name, String aa) throws IOException {
		File file = new File(name);

		InputStream in = null;

		System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽ�");

		in = new FileInputStream(file);

		OutputStream out = new FileOutputStream(aa);

		int tempbyte;

		while ((tempbyte = in.read()) != -1) {
			out.write(tempbyte);
		}

		in.close();
		out.close();
	}

	public static void readFiles(String name, String aa) throws IOException {

		// һ�ζ�ȡ����ֽ�,���ڴ洢�ֽ�
		byte[] tempbyte = new byte[1024];
		// ��ȡͼƬ�ļ�
		InputStream in = new FileInputStream(name);
		// д�뵽Ŀ���ļ���
		OutputStream out = new FileOutputStream(aa);
		int len = 0;
		// ͼƬѭ����ȡ��tempbyte��
		while ((len = in.read(tempbyte)) != -1) {
			// д��
			out.write(tempbyte, 0, len);
		}

		in.close();
		out.close();
	}

	public static void deleteFile(String name) {
		File file = new File(name);
		if (file.exists())
			file.delete();
	}

	public static void main(String[] args) {
		/*
		 * try { readFiles("C:/aaaa.jpg", "C://ff.jpg"); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		deleteFile("c:/ff.jpg");
	}
}

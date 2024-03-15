package com.fox.alibaba.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author F1337248 ShiLeiluo
 * @date 2023-03-13 13:55
 * @version 1.0
 */
public class BookFormat {
	public static void main(String[] args) throws IOException {
		System.out.println("******开始");
		File file = new File("E:\\2023\\WIN\\books\\龙族5悼亡者归来.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
		BufferedReader br = new BufferedReader(inputStreamReader);
		String line;
		int len;
		int n;
		
		File f = new File("E:\\2023\\WIN\\books\\龙族5_format.txt");
		FileOutputStream fileOutputStream = new FileOutputStream(f);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
		BufferedWriter bw = new BufferedWriter(outputStreamWriter);
		while ((line = br.readLine()) != null) {
			len = line.length();
			if (len > 80) {
				n = len/80;
				for (int i = 0; i < n; i++) {
					bw.write(line.substring(i*80, (i+1)*80)+"\n\n");
					if (i+1 == n) {
						bw.write(line.substring((i+1)*80)+"\n\n");
					}
				}
			}else {
				bw.write(line+"\n");
			}
			
		}
		br.close();
		bw.close();
		System.out.println("******结束");
	}
}

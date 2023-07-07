package com.fox.alibaba.socket.moveSQLServerbk;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 文件传输客户端
 * 
 * @author F1338407
 * @date: 2023年2月17日 上午8:49:29
 */
public class MoveSQLServerbk_Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println("-----> 開始保留兩天內的文件");
		preserveFile();
		System.out.println("-----> 保留文件成功");
		String pathString = "D:\\ShiLeiluo";
		String serverip = "10.132.53.236";
		int serverport = 9191;
		File file = new File(pathString);
		File[] files = file.listFiles();
		FileInputStream fis = null;
		DataOutputStream ds = null;
		Socket socket = null;
		if (files.length != 0) {
			try {
				System.out.println("-----> 開始傳輸文件");
				for (int i = 0; i < files.length; i++) {
					socket = new Socket(serverip, serverport);
					System.out.println("-----> " + files[i].getName() + "開始傳輸");
					fis = new FileInputStream(files[i].getAbsolutePath());
					ds = new DataOutputStream(socket.getOutputStream());
					ds.write(i);
					ds.flush();
					// 文件名
					ds.writeUTF(files[i].getName());
					ds.flush();
					// 文件长度
					ds.writeLong(files[i].length());
					ds.flush();
					byte[] bytes = new byte[1024 * 8];
					byte[] bytesPoint = new byte[1024 * 8 * 160];
					int bytesLen = bytes.length;
					int bytesPointLen = bytesPoint.length;
					int length = 0;
					long progress = 0;
					// 文件大小大於500MB接收時使用進度條
					if ((files[i].length() / 1024 / 1024) >= 500) {
						while ((length = fis.read(bytes, 0, bytesLen)) != -1) {
							ds.write(bytes, 0, length);
							ds.flush();
							progress += length;
							if (progress % bytesPointLen == 0 || progress == files[i].length()) {
								ProgressBarUtils pBarUtils = new ProgressBarUtils(50, (long) files[i].length(), '=');
								pBarUtils.show(progress);
							}
						}
					} else {
						while ((length = fis.read(bytes, 0, bytesLen)) != -1) {
							ds.write(bytes, 0, length);
							ds.flush();
						}
					}
					if (socket != null) {
						socket.close();
					}
					System.out.println("-----> " + files[i].getName() + " 傳輸完成");
				}
				System.out.println("-----> 所有文件傳輸完成");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				if (fis != null) {
					fis.close();
				}
				if (ds != null) {
					ds.close();
				}
			}

		} else {
			System.out.println("-----> 文件夾中沒有文件");
		}
		long end = System.currentTimeMillis();
		System.out.println("-----> 耗時：" + (end - start) / 1000 + "s");
	}

	/**
	 * 
	 * @Description: 保留兩天內的文件
	 * @date: 2023年2月23日 上午10:32:30
	 */
	private static void preserveFile() {
		try {
			// Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			// 当前时间的前一天
			int time = Integer.valueOf(simpleDateFormat.format(calendar.getTime()));
			String pathString = "D:\\ShiLeiluo";
			File file = new File(pathString);
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				String lastname = files[i].getName().substring(files[i].getName().indexOf("."),
						files[i].getName().length());
				if (lastname.equals(".bak")) {
					String str1 = fileName.substring(fileName.indexOf("backup_") + 7, fileName.length());
					if (Integer.valueOf(str1.substring(0, 10).replace("_", "")) < time) {
						files[i].delete();
					}
				}
				if (lastname.equals(".txt")) {
					String str2 = fileName.substring(fileName.indexOf("_1_") + 3, fileName.length());
					if (Integer.valueOf(str2.substring(0, 8)) < time) {
						files[i].delete();
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}

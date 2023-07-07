package com.fox.alibaba.socket.moveSQLServerbk;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MoveSQLServerbk_Server {
	private static String pathString = "D:\\ShiLeiluo";
	private static int serverport = 9191;


	public static void main(String[] args) throws Exception {

		System.out.println("-----> 服務端已開啟,等待客戶端連接");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(serverport);
			socket = new Socket();
			// 循环监听等待客户端的连接
			while (true) {
				// 监听客户端
				socket = serverSocket.accept();
				new Thread(new Task(socket)).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		} finally {
			if (serverSocket != null) {
				serverSocket.close();
			}
		}

	}

	public static class Task implements Runnable {
		private Socket socket;
		private DataInputStream dis;
		private FileOutputStream fos;

		public Task(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				dis = new DataInputStream(socket.getInputStream());
				int num = dis.read();
				if (num == 0) {
					deleteFile(pathString);
				}
				// 文件名和长度
				String fileName = dis.readUTF();
				long fileLength = dis.readLong();
				System.out.println("-----> 開始接收文件:" + fileName);
				File file = new File(pathString + File.separatorChar + fileName);
				fos = new FileOutputStream(file);
				// 开始接收文件
				byte[] bytes = new byte[1024 * 8];
				byte[] bytesPoint = new byte[1024 * 8 * 160];
				int bytesLen = bytes.length;
				int bytesPointLen = bytesPoint.length;

				int length = 0;
				long progress = 0;
				// 文件大小大於500MB接收時使用進度條
				if ((fileLength / 1024 / 1024) >= 500) {
					while ((length = dis.read(bytes, 0, bytesLen)) != -1) {
						fos.write(bytes, 0, length);
						fos.flush();
						progress += length;
						if (progress % bytesPointLen == 0 || progress == fileLength) {
							ProgressBarUtils pBarUtils = new ProgressBarUtils(50, (long) fileLength, '=');
							pBarUtils.show(progress);
						}
					}
				} else {
					while ((length = dis.read(bytes, 0, bytesLen)) != -1) {
						fos.write(bytes, 0, length);
						fos.flush();
					}
				}
				System.out.println("-----> 文件接收成功 File:" + fileName + " [Size:" + getFormatFileSize(fileLength) + "]");
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				try {
					if (fos != null)
						fos.close();
					if (dis != null)
						dis.close();
					if (socket != null) {
						socket.close();
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}

	}

	/**
	 * 
	 * @Description: 清空文件夹
	 * @param pathString
	 * @date: 2023年3月9日 上午9:31:56
	 */
	private static void deleteFile(String pathString) {
		File directory = new File(pathString);
		if (!directory.exists()) {
			directory.mkdir();
		}
		File[] files = directory.listFiles();
		File file2 = null;
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				file2 = new File(files[i].getPath());
				file2.delete();
			}
		}
	}

	/**
	 * 格式化文件大小
	 * 
	 * @param fileLength
	 * @return
	 */
	private static String getFormatFileSize(long fileLength) {
		long fileSizeLongKb = fileLength / 1024;
		long fileSizeLongMb = fileSizeLongKb / 1024;
		long fileSizeLongGb = fileSizeLongMb / 1024;
		String fileSizeStr = "0";
		if (fileSizeLongKb > 1024 && fileSizeLongGb == 0) {
			fileSizeStr = String.valueOf(fileSizeLongMb) + "MB";
		} else if (fileSizeLongMb > 1024) {
			fileSizeStr = String.valueOf(fileSizeLongGb) + "GB";
		} else if (fileLength < 1024) {
			fileSizeStr = "1KB";
		} else {
			fileSizeStr = String.valueOf(fileSizeLongKb + "KB");
		}
		return fileSizeStr;
	}

}

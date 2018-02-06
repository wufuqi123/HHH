package cn.dati;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AndroidImage {
	public static String getAdbImage() {
		try {
			
			File directory = new File("");// 参数为空
	         String courseFile = directory.getCanonicalPath();
	         File imagedir=new File(courseFile,"image");
	         if(!imagedir.exists()) {
	        	 imagedir.mkdirs();
	         }
			List<String> cmdshell = new ArrayList<String>();
			cmdshell.add("adb");
			cmdshell.add("shell");
			cmdshell.add("/system/bin/screencap");
			cmdshell.add("-p");
			cmdshell.add("/sdcard/dati.png");
			ProcessBuilder pbshell = new ProcessBuilder();
			pbshell.command(cmdshell);
			pbshell.redirectErrorStream(true);
			Process process = pbshell.start();
			int w = process.waitFor();
	        if (w == 0)// 0代表正常退出
	        {
	        	System.out.println("截图成功" + "\t");
	        	File image=new File(imagedir,"dati.png");
	        	List<String> cmdpull = new ArrayList<String>();
	        	cmdpull.add("adb");
	        	cmdpull.add("pull");
	        	cmdpull.add("/sdcard/dati.png");
	        	cmdpull.add(image.getAbsolutePath());
				ProcessBuilder pbpull = new ProcessBuilder();
				pbpull.command(cmdpull);
				pbpull.redirectErrorStream(true);
				Process processpull = pbpull.start();
				int wpull = processpull.waitFor();
				 if (w == 0)// 0代表正常退出
				{
					 System.out.println("上传成功" + "\t");
					 return image.getAbsolutePath();
				}else {
					System.out.println("上传失败" + "\t");
				}
	        }else {
	        	System.out.println("截图失败" + "\t");
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("adb  异常" + "\t");
		}
		
		return null;
	}
}

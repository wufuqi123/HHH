package cn.dati;

import java.io.File;
import java.io.IOException;

public class RunP {
	public static void run(Callback callback) {
		new Thread() {
			public void run() {
				
				 try {
			            //图片文件：此图片是需要被识别的图片 
					 	long startTime=System.currentTimeMillis();
			            File file = new File(AndroidImage.getAdbImage());
			            if(file.exists()) {
			            	System.out.println("文件存在" + "\t");
			            }else {
			            	System.out.println("文件不存在" + "\t");
			            }
			            File newFile = ImgUtils.cropImage(file);
			            if(file.exists()) {
			            	System.out.println("新文件存在" + "\t");
			            }else {
			            	System.out.println("新文件不存在" + "\t");
			            }
			            String recognizeText = new OCRHelper().recognizeText(newFile);
			            
			            System.out.println(recognizeText + "\t");
			            System.out.println("总耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
			            if(callback!=null) {
			            	callback.succeed(recognizeText);
			            }else {
			            	openDefaultBrowser(recognizeText);
			            }
			        } catch (IOException e) {
			            e.printStackTrace();
			            System.out.println("IO 异常" + "\t");
			        } catch (Exception e) {
			            e.printStackTrace();
			            System.out.println("异常" + "\t");
			        }
				
				
			};
			
			
		}.start();
		
	}
	
	  /** 
     * 打开默认浏览器访问页面 
     */  
    public static void openDefaultBrowser(String str){  
    	if(str==null||str.isEmpty()) {
    		return;
    	}
    	try {
			Runtime.getRuntime().exec("cmd   /c   start   https://www.baidu.com/s?wd="+str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }  
}

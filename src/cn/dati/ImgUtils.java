package cn.dati;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgUtils {
	 /**
     * 裁剪图片方法
     * @param bufferedImage 图像源
     * @param startX 裁剪开始x坐标
     * @param startY 裁剪开始y坐标
     * @param endX 裁剪结束x坐标
     * @param endY 裁剪结束y坐标
     * @return
     */
    public static File cropImage(File newfile) {
    	 int startX; int startY; int endX; int endY;
    	BufferedImage bufferedImage=null;
		try {
			bufferedImage = ImageIO.read(newfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           int width = bufferedImage.getWidth();
           int height = bufferedImage.getHeight();
           startX=BigIntegerUtils.multiply(width, 0.05);
           startY=BigIntegerUtils.multiply(width, 0.2);
           endX=width-startX;
           endY=startY+BigIntegerUtils.multiply(width, 0.68);
           if (startX == -1) {
               startX = 0;
           }
           if (startY == -1) {
               startY = 0;
           }
           if (endX == -1) {
               endX = width - 1;
           }
           if (endY == -1) {
               endY = height - 1;
           }
           BufferedImage result = new BufferedImage(endX - startX, endY - startY, 4);
           for (int x = startX; x < endX; ++x) {
               for (int y = startY; y < endY; ++y) {
                   int rgb = bufferedImage.getRGB(x, y);
                   result.setRGB(x - startX, y - startY, rgb);
               }
           }
           String fileName = newfile.getName();  
           String suffix = fileName.substring(fileName.lastIndexOf(".") + 1); 
           File file = new File(newfile.getParentFile(),"t11111."+suffix);
           try {
        	   ImageIO.write(result, suffix, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
           return file;
       }
}

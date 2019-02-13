package com.herman.archiver;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @ClassName: Archiver
 * @Description: TODO()
 * @author 黄金宝
 * @date 2019年2月13日
 *
 */
public class Archiver {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("D:/archiver/x.xar");
		fos.write(addFile("D:/archiver/1.jpg"));
		fos.write(addFile("D:/archiver/2.xls"));
		fos.write(addFile("D:/archiver/3.docx"));
		fos.close();
	}
	
	private static byte[] addFile(String path) throws Exception {
		//文件
		File f =new File(path);
		//文件名
		String fname = f.getName();
		//文件名数组
		byte[] fnameArr =  fname.getBytes();
		//文件内容长度
		int len = (int)f.length();
		//文件总长度
		int total = 4 + fnameArr.length + 4 + len;
		//初始化总数组
		byte[] bytes = new byte[total]; 
		//文件内容数组
		byte[] fileContentArr;
		
		//1.写入文件名长度
		byte[] fnameLenArr = Util.int2Bytes(fnameArr.length);
		System.arraycopy(fnameLenArr, 0, bytes, 0, 4);
		
		//2.写入文件名内容
		System.arraycopy(fnameArr, 0, bytes, 4, fnameArr.length);
		
		//3.写入文件长度
		byte[] fLenArr = Util.int2Bytes(len);
		System.arraycopy(fLenArr, 0, bytes, 4 + fnameArr.length, 4);
		
		//4.写入文件内容
		ByteArrayOutputStream bos =new ByteArrayOutputStream();
		FileInputStream fis = new FileInputStream(f);
		byte[] buf =new byte[1024];
		int len0 = 0;
		while((len0 = fis.read(buf)) != -1){
			bos.write(buf, 0, len0);
		}
		fis.close();
		fileContentArr=bos.toByteArray();
		System.out.println(len);
		System.out.println(fileContentArr.length);
		System.arraycopy(fileContentArr, 0, bytes, 4 + fnameArr.length + 4, len);
		
		return bytes;
	}
	
}

package com.herman.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
	/** 
	 * @Method_Name: main 
	 * @Description: * @param args
	 * @Description: * @throws Exception void
	 * @date 2019年2月14日
	 * @author 黄金宝 
	 */
	public static void main(String[] args) throws Exception {
		//文件输入流
		FileOutputStream fos = new FileOutputStream("D:/archiver/zip/xxx.xar");
		//压缩流
		ZipOutputStream zos = new ZipOutputStream(fos);
		String[] arr ={ 
				"D:/archiver/1.jpg",
				"D:/archiver/2.xls",
				"D:/archiver/3.docx"
		};
		for (String string : arr) {
			addFile(zos, string);
		}
		zos.close();
		fos.close();
		System.out.println("over");
	}
	
	public static void  addFile(ZipOutputStream zos ,String path) throws Exception {
		File f = new File(path);
		zos.putNextEntry(new ZipEntry(f.getName()));
		FileInputStream fis =new FileInputStream(f);
		byte[] bytes =new byte[fis.available()];
		fis.read(bytes);
		fis.close();
		
		zos.write(bytes);
		zos.closeEntry();
		
	}
}

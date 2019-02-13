package com.herman.archiver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Unarchiver {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<FileBean> files = new ArrayList<>();
		FileInputStream fis = new FileInputStream("D:/archiver/x.xar");
		FileBean fileBean =null;
		
		while ((fileBean = readNextFile(fis)) != null){
			files.add(fileBean);
		}
		fis.close();
		for (FileBean fb : files) {
			FileOutputStream fos = new  FileOutputStream("D:/archiver/unarchiver/"+ fb.getFileName());
			fos.write(fb.getFileContent());
			fos.close();
		}

	}
	
	public static FileBean readNextFile(FileInputStream fis) throws Exception {
		//定义四个字节的临时存储byte空间
		byte[] bytes = new byte[4];//归档时用四个字节保存长度
		int res = fis.read(bytes);
		if(res == -1){//判断读取不到时返回
			return null;
		}
		//文件名长度
		int fnameLen = Util.byte2Int(bytes);
		//文件名数组
		byte[] fnameBytes = new byte[fnameLen];
		//读取文件名内容
		fis.read(fnameBytes);
		//得到文件名
		String fname = new String(fnameBytes);
		//在读四位把文件内容长度读取出来
		fis.read(bytes);
		int fileContLen = Util.byte2Int(bytes);
		
		//读取文件内容
		byte[] fileContBytes = new byte[fileContLen];
		fis.read(fileContBytes);
		
		return new FileBean(fname,fileContBytes);
		
	}

}

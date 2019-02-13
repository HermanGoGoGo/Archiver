package com.herman.archiver;

public class FileBean {

	private String fileName;
	private byte[] fileContent;
	public FileBean() {
		// TODO Auto-generated constructor stub
	}
	
	public FileBean(String fileName,byte[] fileContent) {
		// TODO Auto-generated constructor stub
		this.fileName =fileName;
		this.fileContent=fileContent;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
}

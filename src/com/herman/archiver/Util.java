package com.herman.archiver;

/**
 * @ClassName: Util
 * @Description: TODO()
 * @author 黄金宝
 * @date 2019年2月13日
 *
 */
public class Util {
	public static byte[] int2Bytes(int i){
		byte[] arr = new byte[4];
		arr[0]=(byte)i;
		arr[1]=(byte)(i >> 8);
		arr[2]=(byte)(i >> 16);
		arr[3]=(byte)(i >> 24);
		return arr;
	}
	
	/** 
	 * @Method_Name: byte2Int 
	 * @Description: *  void
	 * @date 2019年2月13日
	 * @author 黄金宝 
	 */
	public static int byte2Int(byte[] bytes){
		int i0 =bytes[0];
		int i1 =(bytes[1] & 0xFF) << 8;
		int i2 =(bytes[2] & 0xFF) << 16;
		int i3 =(bytes[3] & 0xFF) << 24;
		return i0 | i1 | i2 | i3;
	}
}

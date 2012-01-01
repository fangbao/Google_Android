package com.szy.file.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author  coolszy
 * @blog    http://blog.csdn.net/coolszy
 */
public class FileService
{
	/**
	 * �ļ��ı���
	 * @param outStream
	 * @param content
	 * @throws IOException
	 */
	public void save(OutputStream outStream,String content) throws IOException
	{
		outStream.write(content.getBytes());
		outStream.close();
	}
	
	/*
	 * ��ȡ�ļ���Ϣ
	 */
	public String read(InputStream inStream) throws IOException
	{
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while((len=inStream.read(buffer))!=-1)
		{
			outStream.write(buffer, 0, len);
		}
		byte[] data = outStream.toByteArray();
		outStream.close();
		inStream.close();
		return new String(data);
	}
}

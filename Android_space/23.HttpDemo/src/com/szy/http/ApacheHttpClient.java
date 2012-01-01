package com.szy.http;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


/**
 *@author coolszy
 *@date 2011-5-29
 *@blog http://blog.csdn.net/coolszy
 */

/**
 * ��ͬ����ʽ����Http����
 */
public class ApacheHttpClient
{

	/**
	 * ��Get��ʽ��������
	 * @param url ����·��
	 * @return
	 */
	public String httpGet(String url)
	{
		String response = null;
		HttpClient httpclient = new DefaultHttpClient();
		//����HttpGet����
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse;
		try
		{
			//ʹ��execute��������HTTP GET���󣬲�����HttpResponse����
			httpResponse = httpclient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if(statusCode==HttpStatus.SC_OK)
			{
				//��÷��ؽ��
				response = EntityUtils.toString(httpResponse.getEntity());
			}
			else
			{
				response = "�����룺"+statusCode;
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
		
	}

	/**
	 * ��Post��ʽ��������
	 * @param url �����ַ
	 * @param params ���� ��Post��ʽ������NameValuePair[]���д������
	 * @return
	 * @throws Exception
	 */
	public String httpPost(String url, List<NameValuePair> params) throws Exception
	{
		String response = null;
		HttpClient httpclient = new DefaultHttpClient();
		//����HttpPost����
		HttpPost httppost = new HttpPost(url);
		try
		{
			//����httpPost�������
			httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
			//ʹ��execute��������HTTP Post���󣬲�����HttpResponse����
			HttpResponse httpResponse = httpclient.execute(httppost);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if(statusCode==HttpStatus.SC_OK)
			{
				//��÷��ؽ��
				response = EntityUtils.toString(httpResponse.getEntity());
			}
			else
			{
				response = "�����룺"+statusCode;
			}
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}
}

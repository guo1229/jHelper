package com.ht;
import java.util.HashMap;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
/**
 * 
 * @ClassName: CloudCommunication
 * @Description: ���ŷ��͹�����
 * @author: huchenghao
 * @date: 2017��9��26�� ����12:38:55
 */
public class CloudCommunication {
	/*
	 * �������˵�ַ 
	 *  ����:sandboxapp.cloopen.com 
	 *  ����:app.cloopen.com
	 */
	public static String serverIP = "app.cloopen.com";
	
	public static String serverPort = "8883";//�˿�
	
	public static CCPRestSmsSDK smsapi = null;
	
	public HashMap<String, Object> result = null;
	
	
	/*
	 * ��ʼ����������ַ�Ͷ˿�
	 * ��ʼ�����˺ź����˺�����
	 * ��ʼ��Ӧ��ID
	 */
	public CloudCommunication() {
		
	}

	/**
	 * 
	 * @Title: sendSmsByTemplet
	 * @Description: ���ŷ���
	 * @param phone
	 * @param datas
	 * @param account_sid
	 * @param auth_token
	 * @param app_id
	 * @param templet_id
	 * @return
	 * @return: boolean
	 */
	public static boolean sendSmsByTemplet(String phone, String[] datas,String account_sid,String auth_token,String app_id,String templet_id) {
		try{
			smsapi = new CCPRestSmsSDK();
			smsapi.init(serverIP, serverPort);
			smsapi.setAccount(account_sid, auth_token);
			smsapi.setAppId(app_id);
			smsapi.sendTemplateSMS(phone, templet_id, datas);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
}

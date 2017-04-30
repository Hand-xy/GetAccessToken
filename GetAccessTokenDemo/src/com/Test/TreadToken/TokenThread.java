package com.Test.TreadToken;

import com.Test.Dto.AccessToken;
import com.Test.Util.AccessTokenUtil;

public class TokenThread implements Runnable {
	public static final String appID = "wx07f9e605277d3336";
	public static final String appScret = "5cbf00f31cb42b62cd192f14875515a2";
	public static AccessToken access_token = null;

	@Override
	public void run() {
		while (true) {
			try {
				// ���ù������ȡaccess_token(ÿ������ȡ100000�Σ�ÿ�λ�ȡ����Ч��Ϊ7200��)
				access_token = AccessTokenUtil.getAccessToken(appID, appScret);

				if (null != access_token) {
					System.out.println("accessToken��ȡ�ɹ���" + access_token.getExpires_in());
					// 7000��֮�����½��л�ȡ
					Thread.sleep((access_token.getExpires_in() - 200) * 1000);
					//Thread.sleep(10 * 1000);
				} else {
					// ��ȡʧ��ʱ��60��֮�������»�ȡ
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

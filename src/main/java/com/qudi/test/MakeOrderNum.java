package com.qudi.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MakeOrderNum
 * @CreateTime 2015��9��13�� ����4:51:02
 * @author : mayi
 * @Description: ���������ɹ���,���ɷ��ظ�������,��������1����1000��,����չ
 **/
public class MakeOrderNum {
	/**
	 * ������,����Ϊ�������
	 */
	private static Object lockObj = "lockerOrder";
	/**
	 * ���������ɼ�����
	 */
	private static long orderNumCount = 0L;
	/**
	 * ÿ�������ɶ������������ֵ
	 */
	private int maxPerMSECSize = 999;

	/**
	 * ���ɷ��ظ�������,��������1����1000��,����չ
	 * 
	 * @param tname ������
	 */
	public String makeOrderNum(String tname) {
		// �������ɵĶ�����
		String finOrderNum = "";
		try {
			synchronized (lockObj) {
				// ȡϵͳ��ǰʱ����Ϊ�����ű���ǰ�벿��,��ȷ������
				long nowLong = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
				// �����������ֵ����,����չ����,Ŀǰ1���봦���ֵ1000��,1��100��
				if (orderNumCount > maxPerMSECSize) {
					orderNumCount = 0L;
				}
				// ��װ������
				if (orderNumCount < 10) {
					finOrderNum = nowLong + "00" + orderNumCount;
				}
				if (orderNumCount > 9 && orderNumCount < 100) {
					finOrderNum = nowLong + "0" + orderNumCount;
				}
				if (orderNumCount > 99) {
					finOrderNum = nowLong + "" + orderNumCount;
				}
				orderNumCount++;
				// System.out.println(finOrderNum + "--" + Thread.currentThread().getName() +
				// "::" + tname);
				// Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finOrderNum;
	}

	public static void main(String[] args) {
		// ���Զ��̵߳��ö��������ɹ���
		try {
			for (int i = 0; i < 200; i++) {
				Thread t1 = new Thread(new Runnable() {
					public void run() {
						MakeOrderNum makeOrder = new MakeOrderNum();
						makeOrder.makeOrderNum("a");
					}
				}, "at" + i);
				t1.start();
				Thread t2 = new Thread(new Runnable() {
					public void run() {
						MakeOrderNum makeOrder = new MakeOrderNum();
						makeOrder.makeOrderNum("b");
					}
				}, "bt" + i);
				t2.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

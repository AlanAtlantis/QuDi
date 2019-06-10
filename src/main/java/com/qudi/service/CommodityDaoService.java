package com.qudi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.qudi.bean.Commodity;
import com.qudi.bean.Price;
import com.qudi.bean.Specifications;
import com.qudi.util.MessageUtil;

public interface CommodityDaoService {
	/**
	 * ��ѯ������Ʒ��Ϣ
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil queryCommodity(int id);

	/**
	 * �����Ʒ
	 * 
	 * @param comm
	 * @param session
	 * @return
	 */
	MessageUtil insertCommodity(Commodity comm, HttpSession session);

	/**
	 * �޸ĸ���Ʒ
	 * 
	 * @param comm
	 * @return
	 */
	MessageUtil updateCommdity(Commodity comm);

	/**
	 * ɾ����Ʒ
	 * 
	 * @param comm
	 * @return
	 */
	MessageUtil deleteCommodity(int id);

	/**
	 * �����Ʒ�۸�
	 * 
	 * @param pirce
	 * @param CommdityId
	 * @return
	 */
	MessageUtil insertQdPrice(Price pirce, int commodityId);

	/**
	 * �����Ʒ���
	 * 
	 * @param specifications
	 * @param CommdityId
	 * @return
	 */
	MessageUtil insertQdSpecifications(Specifications specifications, int commodityId);

	/**
	 * �޸���Ʒ�۸�
	 * 
	 * @param price
	 * @return
	 */
	MessageUtil updatePrice(Price price);

	/**
	 * �޸���Ʒ���
	 * 
	 * @param specifications
	 * @return
	 */
	MessageUtil updateQdSpecifications(Specifications specifications);

	/**
	 * ɾ����Ʒ�۸�
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deletePrice(int id);

	/**
	 * ɾ����Ʒ���
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteSpecifications(int id);

	/**
	 * Query commodity set
	 * 
	 * @param sesion
	 * @return
	 */
	MessageUtil queryUserCommodtiyList(HttpSession sesion);

	/**
	 * ������Ʒ
	 * 
	 * @param keyword
	 * @return
	 */
	MessageUtil queryLikeCommodity(String keyword);

}

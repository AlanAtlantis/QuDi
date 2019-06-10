package com.qudi.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qudi.bean.Commodity;
import com.qudi.bean.Price;
import com.qudi.bean.Specifications;
import com.qudi.bean.User;
import com.qudi.dao.CommodityDao;
import com.qudi.service.CommodityDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Repository("commodityService")
public class CommodityDaoServiceImpl implements CommodityDaoService {

	@Autowired
	private CommodityDao commodityDao;

	public MessageUtil queryCommodity(int id) {
		MessageUtil message = new MessageUtil();
		if (id > 0) {
			System.out.println(id);
			//查询商品  Query the goods
			Commodity comm = commodityDao.queryCommodity(id);

			if (comm != null) {
				// 查询商品与价格关系   Inquire about the relationship between goods and prices
				List<Integer> idList = commodityDao.queryCommodity2Price(id);
				System.out.println("------>"+idList);
				//查询商品价格  Inquire commodity prices
				List<Price> priceList = commodityDao.queryPrice(idList);
				// 查询商品规格id   Enquiry of commodity specifications id
				List<Integer> idsList = commodityDao.querySpecificationsIdList(id);
				// 查询商品规格   Enquiry of commodity specifications
				List<Specifications> specificationsList = commodityDao.querySpecificationsList(idsList);

				comm.setPrice(priceList);
				comm.setSpecifications(specificationsList);
				message.setObject(comm);
				message.setInfo("The query is successful");
				message.setResult(Result.SUCCEED);
				return message;
			}
		}
		message.setInfo("The query fails");
		return message;
	}

	public MessageUtil insertCommodity(Commodity comm, HttpSession sesion) {
		MessageUtil message = new MessageUtil();
		// �ж���Ʒ��Ϊ��
		if (comm != null) {
			if (commodityDao.insertCommodity(comm) > 0) {
				System.out.println("------>>>id:" + comm.getId());
				User user = (User) sesion.getAttribute("user");
				// �����Ʒ���û��Ĺ�ϵ
				commodityDao.insertQdUser2Commodity(user.getId(), comm.getId());

				message.setResult(Result.SUCCEED);
				message.setInfo("��ӳɹ�");
				return message;
			}

		}
		message.setInfo("�����������ʧ��");
		return message;

	}

	public MessageUtil updateCommdity(Commodity comm) {
		MessageUtil message = new MessageUtil();
		if (comm != null) {

			if (commodityDao.updateCommdity(comm) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("�޸ĳɹ�");
				return message;
			}
		}
		message.setInfo("���������޸�ʧ��");
		return message;
	}

	public MessageUtil deleteCommodity(int id) {
		MessageUtil message = new MessageUtil();
		if (id != 0) {

			if (commodityDao.deleteCommodity(id) > 0) {
				// 删除用户和商品关系 Delete user and merchandise relationships
				commodityDao.deleteQdUser2Commodity(id);
				// 查询商品与价格关系 Inquire about the relationship between goods and prices
				List<Integer> idList = commodityDao.queryCommodity2Price(id);
				// 删除价格 Delete the price
				commodityDao.deleteQdPrice(idList);
				// 根据商品id查询规格 Query the specification by item id
				List<Integer> idsList = commodityDao.querySpecificationsIdList(id);
				// 删除商品规格 Delete product specifications
				commodityDao.deleteQdSpecifications(idsList);
				// 删除商品与价格关系 Delete the relationship between goods and prices
				commodityDao.deleteQdCommodity2Price(id, 0);
				// 删除商品与规格关系 Remove item and specification relationship
				commodityDao.deleteQdCommodity2Specifications(id, 0);
				message.setResult(Result.SUCCEED);
				message.setInfo("Delete the success");
				return message;
			}
		}
		message.setInfo("Delete failed");
		return message;
	}

	public MessageUtil insertQdPrice(Price price, int commodityId) {
		MessageUtil message = new MessageUtil();
		if (price != null) {
			if (commodityDao.insertQdPrice(price) > 0) {
				// �����Ʒ����Ʒ�۸��ϵ
				commodityDao.insertQdCommodity2Price(commodityId, price.getId());
				message.setResult(Result.SUCCEED);
				message.setInfo("��ӳɹ�");
				return message;
			}
		}
		message.setInfo("�����������ʧ��");
		return message;
	}

	public MessageUtil insertQdSpecifications(Specifications specifications, int commodityId) {
		MessageUtil message = new MessageUtil();
		if (specifications != null) {
			if (commodityDao.insertQdSpecifications(specifications) > 0) {
				// �����Ʒ����Ʒ���Ĺ�ϵ
				commodityDao.insertQdCommodity2Specifications(commodityId, specifications.getId());
				message.setResult(Result.SUCCEED);
				message.setInfo("��ӳɹ�");
				return message;
			}
		}
		message.setInfo("�����������ʧ��");
		return message;

	}

	public MessageUtil updatePrice(Price price) {
		MessageUtil message = new MessageUtil();
		if (price != null) {
			if (commodityDao.updatePrice(price) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("�޸ĳɹ��ɹ�");
				return message;
			}

		}
		message.setInfo("���������޸�ʧ��");
		return message;
	}

	public MessageUtil updateQdSpecifications(Specifications specifications) {
		MessageUtil message = new MessageUtil();
		if (specifications != null) {
			if (commodityDao.updateQdSpecifications(specifications) > 0) {
				message.setResult(Result.SUCCEED);
				message.setInfo("�޸ĳɹ��ɹ�");
				return message;
			}
		}
		message.setInfo("���������޸�ʧ��");
		return message;
	}

	public MessageUtil deletePrice(int id) {
		MessageUtil message = new MessageUtil();
		if (id != 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(id);
			if (commodityDao.deleteQdPrice(list) > 0) {
				// ɾ����Ʒ�۸�����Ʒ��ϵ
				commodityDao.deleteQdCommodity2Price(0, id);
				message.setResult(Result.SUCCEED);
				message.setInfo("ɾ���ɹ�");
				return message;
			}
		}
		message.setInfo("��������ɾ��ʧ��");
		return message;
	}

	public MessageUtil deleteSpecifications(int id) {
		MessageUtil message = new MessageUtil();
		if (id != 0) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(id);
			if (commodityDao.deleteQdSpecifications(list) > 0) {
				// ɾ���������Ʒ��ϵ
				commodityDao.deleteQdCommodity2Specifications(0, id);
				message.setResult(Result.SUCCEED);
				message.setInfo("ɾ���ɹ�");
				return message;
			}
		}
		message.setInfo("��������ɾ��ʧ��");
		return message;
	}

	public MessageUtil queryUserCommodtiyList(HttpSession sesion) {
		MessageUtil message = new MessageUtil();

		User user = (User) sesion.getAttribute("user");
		System.out.println("----->>>" + user);
		if (user != null) {
			// 根据用户id查询商品id Query the product id based on the user id
			List<Integer> idList = commodityDao.querUserCommodityId(user.getId());
			System.out.println("\n---------->>" + idList.toString());
			// 根据商品id查询商品 Search for items by item id
			List<Commodity> comm = commodityDao.queryUserCommodtiyList(idList);
			System.out.println("\n---------->>" + comm.toString());
			if (comm.size() > 0) {
				message.setObject(comm);
				message.setResult(Result.SUCCEED);
				message.setInfo("The query is successful");
				return message;
			}
			message.setInfo("The query fails");
			return message;
		}
		message.setInfo("Parameter error");
		return message;
	}

	public MessageUtil queryLikeCommodity(String keyword) {
		MessageUtil message = new MessageUtil();

		if (keyword != null) {
			// ƴ�Ӳ�ѯ�ַ�
			StringBuffer str = new StringBuffer("%");
			str.append(keyword);
			str.append("%");
			// ���ݹؼ��ֽ��в�ѯ
			List<Commodity> commList = commodityDao.queryLikeCommodity(str.toString());
			if (commList.size() > 0) {
				message.setObject(commList);
				message.setResult(Result.SUCCEED);
				message.setInfo("�����ɹ�");
				return message;
			}
			message.setInfo("������Ʒ");
			return message;
		}
		message.setInfo("�������󣬲��ܽ�������");
		return message;
	}

}

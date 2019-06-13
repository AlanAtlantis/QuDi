package com.qudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qudi.bean.GoodsList;
import com.qudi.dao.GoodsListDao;
import com.qudi.service.GoodsListDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Service
public class GoodsListDaoServiceImpl implements GoodsListDaoService {

	@Autowired
	private GoodsListDao goodsListDao;

	public MessageUtil add(GoodsList goods) {
		MessageUtil message = new MessageUtil();
		if (goods != null) {

			if (goodsListDao.add(goods) > 0) {
				goodsListDao.addShop2Goods(1, goods.getGoodsId());
				message.setInfo("successfully added");
				message.setResult(Result.SUCCEED);
				return message;
			}
			message.setInfo("fail to add");
			return message;
		}
		message.setInfo("parameter error");
		return message;
	}

	@Override
	public MessageUtil selectGoodsList(int userId) {
		MessageUtil message = new MessageUtil();

		if (userId > 0) {

			List<GoodsList> list = goodsListDao.selectGoodsList(userId);

			if (list.size() > 0) {
				message.setObject(list);
				message.setInfo("The query is successful");
				message.setResult(Result.SUCCEED);
				return message;

			}
			message.setInfo("no data");
			return message;
		}

		message.setInfo("parameter error");
		return message;
	}

}

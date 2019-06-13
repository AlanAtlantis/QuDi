package com.qudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qudi.bean.GoodsList;
import com.qudi.service.GoodsListDaoService;
import com.qudi.util.MessageUtil;
import com.qudi.util.Result;

@Controller
@RequestMapping("/sys/goodsList")
public class GoodsListContr {

	@Autowired
	private GoodsListDaoService goodsListService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, GoodsList goods, HttpServletRequest request) {

		// 暂时指定用户id
		goods.setUserId(1);

		MessageUtil message = goodsListService.add(goods);

		System.out.println("------>>>>>>>>>........>>>>>>>aaaaaaa" + message);
		/*
		 * if (message.getResult() == Result.SUCCEED) { selectGoodsList(model, request);
		 * }
		 */

		return "insert";
	}

	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String selectGoodsList(Model model, HttpServletRequest request) {
		// 暂时指定用户，
		int userId = 1;
		// goodsListService.selectGoodsList(userId);
		model.addAttribute("message", goodsListService.selectGoodsList(userId));
		System.out.println("------>>>>>>>>>........>>>>>>>a进入商品例表a");
		return "tables";
	}

}

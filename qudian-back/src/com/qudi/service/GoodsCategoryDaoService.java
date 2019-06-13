package com.qudi.service;

import org.springframework.stereotype.Service;

import com.qudi.util.MessageUtil;

public interface GoodsCategoryDaoService {

	MessageUtil selectGoodsCategory();

	MessageUtil selectGoodsCategoryLevel(int id, int categoryLevel);

}

package com.qudi.service;

import com.qudi.bean.Bargain;
import com.qudi.util.MessageUtil;

public interface BargainDaoService {
	/**
	 * 添加议价
	 * 
	 * @param bargain
	 * @return
	 */
	MessageUtil insertBargain(Bargain bargain);

	/**
	 * 删除议价
	 * 
	 * @param id
	 * @return
	 */
	MessageUtil deleteBargain(int id);

	/**
	 * 用户 查询议价
	 * 
	 * @param userId
	 * @return
	 */
	MessageUtil selectBargainUser(int userId);

	/**
	 * 查看商品所有议价
	 * 
	 * @param commodityId
	 * @return
	 */
	MessageUtil selectBargainCommodity(int commodityId);

	/**
	 * 修改议价
	 * 
	 * @param bargain
	 * @return
	 */
	MessageUtil updateBargain(Bargain bargain);
}

package com.neuq.biz;

import com.neuq.entities.Stock;

public interface IStockBiz {
	/**
	 * 根据股票代码查询出该股票详情
	 * @param stockcode
	 * @return
	 */
	public Stock queryStock(int stockcode);
}

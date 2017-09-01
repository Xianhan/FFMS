package com.neuq.biz;

import com.neuq.entities.Stock;
//查询要买的股票信息
public interface ISelectSaleInfoBiz {
	public Stock selectSaleInfo(int code);

}

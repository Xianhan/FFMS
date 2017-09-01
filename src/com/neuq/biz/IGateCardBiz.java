package com.neuq.biz;

import java.util.List;

import com.neuq.entities.GateCard;

public interface IGateCardBiz {
	/**
	 * 签到
	 * @param gatecard
	 * @return
	 */
	public boolean signOn(GateCard gatecard) ;
	/**
	 * 查询昨天连续签到天数，如果昨天签到记录为空，则为0；
	 * @param yesterday
	 * @return
	 */
	public int queryDays(String yesterday,int userid);
	/**
	 * 查询本月签到的日期
	 * @param userid
	 * @return
	 */
	public List<String> queryAllDay(int userid);
}

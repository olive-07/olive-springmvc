package com.info.back.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.info.back.service.impl.ITaskJob;

import redis.clients.jedis.JedisCluster;

@Component("taskJob")
public class TaskJob implements ITaskJob {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private JedisCluster jedisCluster;
	// @Autowired
	// private IRepaymentService repaymentService;
	// @Autowired
	// @Autowired
	// private IUserService userService;
	// @Autowired
	// private IRundockingOrdersService rundockingOrdersService;

	@Override
	public void overdue() {
		System.out.println("测试quertz：" + jedisCluster.get("RD_RUNDOCKIN0_ID"));
		//
		// logger.info("融都分润数据推送同步任务开始---------->overdue start");
		// /* 融都分润处理 */
		// try {
		//
		// params.clear();
		// Integer stus[] = new Integer[]
		// {STATUS_CSBH,STATUS_FSBH,STATUS_FKBH,STATUS_FKSB,ORDER_CLOSE};
		// params.put("statuses",stus);
		// params.put("profitPush","0");
		// params.put("userFrom", jedisCluster.get("RD_RUNDOCKIN0_ID"));
		// params.put("releaseTime", ConstantRundocking.RELEASE_TIME);
		// List<BorrowOrder> borrowOrders =
		// borrowOrderService.findNeedProfitPushBorrow(params);
		// loseMoneyActionNL(borrowOrders);
		//
		// params.clear();
		// Integer stus1[] = new Integer[] {STATUS_BFHK, STATUS_YYQ, STATUS_YHZ
		// };
		// params.put("statuses",stus1);
		// params.put("profitPush","0");
		// params.put("userFrom", jedisCluster.get("RD_RUNDOCKIN0_ID"));
		// params.put("loanDuration",
		// Integer.parseInt(jedisCluster.get("RD_RUNDOCKIN0_TERM") == null ?
		// "60" : jedisCluster.get("RD_RUNDOCKIN0_TERM")));
		// params.put("releaseTime", ConstantRundocking.RELEASE_TIME);
		// List<Repayment> repayments =
		// repaymentService.findNeedProfitPush(params);
		// loseMoneyActionBD(repayments);
		//
		// } catch (Exception e) {
		// logger.error("overdue RDShareUtil error ",e);
		// }
		// logger.info("融都分润数据推送同步任务开始---------->overdue end");
	}
	//
	// private void loseMoneyActionNL(List<BorrowOrder> borrowOrders){
	//
	// logger.info("融都分润数据推送同步任务开始---------->loseMoneyActionNL start");
	// long time = System.currentTimeMillis();
	// int count = 0;
	// try {
	// if(borrowOrders != null){
	//
	// logger.info("LOSELOAN 4 back loseMoneyActionNL start
	// count:========="+borrowOrders.size());
	// for (BorrowOrder borrowOrder : borrowOrders) {
	//
	// if(borrowOrder == null){
	// continue;
	// }
	// BorrowOrder bo =
	// borrowOrderService.findOneBorrow(borrowOrder.getId());//查询借款详情
	// if(bo == null){
	// logger.info("LOSELOAN 4 start======未查到还款订单："+borrowOrder.getId());
	// continue;
	// }
	//
	// logger.info("LOSELOAN to 4 start==========borrowId:"+bo.getId());
	//
	// Map<String, Object> pars = new TreeMap<String, Object>();
	// pars.put("businessType", ConstantRundocking.BUSINESSTYPE_NL);//1申请未放款
	// 2是坏账 3 盈利
	// pars.put("timeType", bo.getLoanMethod());//类型
	// pars.put("timeLimit", bo.getLoanTerm());//期限
	// pars.put("poundage", (double)bo.getLoanInterests()/100);//服务费
	// pars.put("intoMoney", (double)(bo.getIntoMoney() == null ? 0 :
	// bo.getIntoMoney())/100);//实际到账金额
	// //pars.put("turnover", "0");//交易金额
	// pars.put("replayDays", DateUtil.daysBetween(bo.getCreatedAt(), new
	// Date()));//距借款天数
	//// pars.put("amount",
	// ConstantRundocking.profitCalculation((long)bo.getMoneyAmount(),bo.getIntoMoney(),(long)0,-1
	//// , (long)bo.getLoanInterests()));
	// pars.put("orderNo", "LOSELOAN_"+bo.getId());
	// pars.put("userId", borrowOrder.getUserId()+"");
	// pars.put("remark", "放款失败");
	// pars.put("orderTime", DateUtil.getDateFormat("yyyy-MM-dd HH:mm:ss"));
	// pars.put("needPayment", (double)bo.getMoneyAmount()/100);//应还金额
	// pars.put("apr", jedisCluster.get("RD_RUNDOCKIN0_RATE"));
	// pars.put("act", ConstantRundocking.POST_FAIL);
	//
	// String result =
	// RDShareUtil.loseMoney(pars,rundockingOrdersService,jedisCluster);
	// if(RundockingOrders.STATUS_SUC.equals(result)){
	// bo.setProfitPush(1);
	// borrowOrderService.updateProfitPushBorrowById(bo);
	// }
	//
	// }
	// count = borrowOrders.size();
	// }
	// } catch (Exception e) {
	// logger.error("loseMoneyActionNL RDShareUtil error ",e);
	// }
	// logger.info("融都分润数据推送同步任务结束---------->loseMoneyActionNL end
	// 用时："+(System.currentTimeMillis() - time)+"共处理： " + count);
	// }
	// private void loseMoneyActionBD(List<Repayment> repaymentfails){
	//
	// logger.info("融都分润数据推送同步任务开始---------->loseMoneyActionBD start");
	// long time = System.currentTimeMillis();
	// int count = 0;
	// try {
	// if(repaymentfails != null){
	//
	// logger.info("REPAYMENT 4 back loseMoneyActionBD start
	// count:========="+repaymentfails.size());
	// for (Repayment re : repaymentfails) {
	//
	// if(re == null){
	// continue;
	// }
	//
	// Repayment repayment = repaymentService.selectByPrimaryKey(re.getId());
	// if(repayment == null){
	// logger.info("REPAYMENT 4 start======未查到还款订单："+re.getId());
	// continue;
	// }
	//
	// logger.info("REPAYMENT to 4
	// start==========borrowId:"+repayment.getAssetOrderId());
	// BorrowOrder bo =
	// borrowOrderService.findOneBorrow(repayment.getAssetOrderId());//查询借款详情
	// Map<String, Object> pars = new TreeMap<String, Object>();
	// pars.put("businessType", ConstantRundocking.BUSINESSTYPE_BD);//1申请未放款
	// 2是坏账 3 盈利
	// pars.put("timeType", bo.getLoanMethod());//类型
	// pars.put("timeLimit", bo.getLoanTerm());//期限
	// pars.put("poundage", (double)bo.getLoanInterests()/100);//服务费
	// pars.put("intoMoney", (double)(bo.getIntoMoney() == null ? 0 :
	// bo.getIntoMoney())/100);//实际到账金额
	// //pars.put("turnover", "0");//交易金额
	// pars.put("replayDays",
	// DateUtil.daysBetween(repayment.getCreditRepaymentTime(), new
	// Date()));//距借款天数
	//// pars.put("amount",
	// ConstantRundocking.profitCalculation(repayment.getRepaymentAmount(),bo.getIntoMoney(),(long)0,ConstantRundocking.TD_LOANDURATION+1
	//// , repayment.getRepaymentInterest()));
	// pars.put("orderNo", "REPAYMENTFAIL_"+repayment.getId());
	// pars.put("userId", re.getUserId()+"");
	// pars.put("remark", "坏账");
	// pars.put("orderTime", DateUtil.getDateFormat("yyyy-MM-dd HH:mm:ss"));
	// pars.put("needPayment",
	// (double)repayment.getRepaymentAmount()/100);//应还金额
	// pars.put("apr", jedisCluster.get("RD_RUNDOCKIN0_RATE"));
	// pars.put("act", ConstantRundocking.POST_FAIL);
	//
	// String result =
	// RDShareUtil.loseMoney(pars,rundockingOrdersService,jedisCluster);
	// if(RundockingOrders.STATUS_SUC.equals(result)){
	// repayment.setProfitPush(1);
	// repaymentService.updateProfitPushById(repayment);
	// }
	//
	// }
	// count = repaymentfails.size();
	// }
	// } catch (Exception e) {
	// logger.error("loseMoneyActionBD RDShareUtil error ",e);
	// }
	// logger.info("融都分润数据推送同步任务结束---------->loseMoneyActionBD end
	// 用时："+(System.currentTimeMillis() - time)+"共处理： " + count);
	// }

}

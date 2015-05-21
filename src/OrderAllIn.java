//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Stack;
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * 描述：<>
// * @author zn
// * @CreateTime 2015-4-2下午8:17:17
// */
//
//
//public class OrderAllIn {
//	int nBlock = 0;//提交操作因为网络阻塞被终止了几次
//	int nBackOffBase = 2;//回退操作的基数
//	final int nBackOffLimit = 1000;
//	ArrayList<Goods> goodsToBuyBasket = new ArrayList<Goods>();//存放购物车里未提交订单的商品
//	
//	//内部类：OrderTask 尝试一次订单提交
//	class OrderTask extends TimerTask{
//		public void orderOne(Goods ){
//			
//		}
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
//	//二进制指数退让 决定 回退等待时间，
//	int backOffTime(){
//		return Math.min((int)Math.pow(nBackOffBase, nBlock), nBackOffLimit);
//	}
////判断购物车里的东西是否提交完了
//	boolean isOK(){
//		return goodsToBuyBasket.isEmpty();
//	}
//	//
//int placeOrder(){
//	Calendar date = Calendar.getInstance();
//	//设置初始化延时操作，距离0点还有多长时间
//	long delay = ;
//	while(!isOK()){
//		Timer t = new Timer();
//		OrderTask ot = new OrderTask(); 
//		t.schedule(new TimerTask() {
//		   , date.getTime(), dalay); //daySpan是一天的毫秒数，也是执行间隔
//		};
//		
//	}
//	}
//}

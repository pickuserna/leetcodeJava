//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Stack;
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * ������<>
// * @author zn
// * @CreateTime 2015-4-2����8:17:17
// */
//
//
//public class OrderAllIn {
//	int nBlock = 0;//�ύ������Ϊ������������ֹ�˼���
//	int nBackOffBase = 2;//���˲����Ļ���
//	final int nBackOffLimit = 1000;
//	ArrayList<Goods> goodsToBuyBasket = new ArrayList<Goods>();//��Ź��ﳵ��δ�ύ��������Ʒ
//	
//	//�ڲ��ࣺOrderTask ����һ�ζ����ύ
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
//	//������ָ������ ���� ���˵ȴ�ʱ�䣬
//	int backOffTime(){
//		return Math.min((int)Math.pow(nBackOffBase, nBlock), nBackOffLimit);
//	}
////�жϹ��ﳵ��Ķ����Ƿ��ύ����
//	boolean isOK(){
//		return goodsToBuyBasket.isEmpty();
//	}
//	//
//int placeOrder(){
//	Calendar date = Calendar.getInstance();
//	//���ó�ʼ����ʱ����������0�㻹�ж೤ʱ��
//	long delay = ;
//	while(!isOK()){
//		Timer t = new Timer();
//		OrderTask ot = new OrderTask(); 
//		t.schedule(new TimerTask() {
//		   , date.getTime(), dalay); //daySpan��һ��ĺ�������Ҳ��ִ�м��
//		};
//		
//	}
//	}
//}

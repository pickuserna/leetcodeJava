/**
 * ÃèÊö£º<>
 * @author zn
 * @CreateTime 2015-4-1ÏÂÎç8:05:03
 */
public class BestSell {

	/**
	 * TODO:<>
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 0 ,b =1 ;
		int c = (a++) + (a++) ;
		int d = (a++);
		int h = "123".length();
		char ccc = 13;
		float z = 1.0f;
		Short sss= 2;
		System.out.println(b+",  a:  "+a+"  c"+c);
		int prices[] = {1,5,3,4};
		System.out.println(maxProfit(prices));
		
	}
	 public static int maxProfit(int[] prices) {
	        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
	        int release1 = 0, release2 = 0;
	        for(int i:prices){                              // Assume we only have 0 money at first
	        	hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
	            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1st stock so far.
//	            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
//	            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
	            
	        }
	        System.out.println(release2+"    ,release1:"+release1);
	        return release1; ///Since release1 is initiated as 0, so release2 will always higher than release1.
	    }
}

package trapwater;

import java.util.Arrays;
import java.util.Stack;

/**
 * 描述：<淹没法，挡板有两种形式，在水槽的两端->墙，在水的下方->水床：比它所处于的水槽两端的墙低>
 * @author zn
 * @CreateTime 2015-4-13下午12:46:37
 */
public class TrapWater2 {

	/**
	 * TODO:<>
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//类名错误，
		TrapWater2 tw2 = new TrapWater2();
		int a[]  = {4,2,3};
		System.out.println(tw2.trap(a));
	}

	public int trap(int[] A){
	
		int leftIndex = 0;
		// 栈s 中存放可能成为墙的 位置
		Stack<Integer> s = new Stack<Integer>();
		s.push(leftIndex);
		int sum = 0;
		for(int i=1; i<A.length; i++){
			//填充一个连通的水槽
			int leftHeight = A[leftIndex];
			if(A[i]>=leftHeight)
			{	
				for(int j=i-1; j>leftIndex; j--){
					sum += leftHeight - A[j];
				}
				s.clear();
				leftIndex = i;
				s.push(leftIndex);
				//continue
				continue;
			}
			//遇到可能的墙，淹没该墙之前比它低的墙，该墙入栈
			if(A[i] > A[i-1]){
				//!!!!!!!!ERROR!!!!!!!!!Empty Stack
//				int top = s.peek();
//				while (B[top]<=B[i])
//				{
//					s.pop();
//					if(s.empty())
//						break;
//					top = s.peek();
//				}
				while(!s.empty() && A[s.peek()] <=A[i]){
					s.pop();
				}
				s.push(i);
			}
		}
		//填充栈s中的水槽(左部的墙)
		if(!s.empty()){
			int right = s.pop();
			while(!s.empty()){
				int left = s.pop();
				sum += fillWater2(A, left, right, A[right]);
				right = left;
			}
		}
		return sum;
	}
	private int fillWater2(int[] a, int left, int right , int value){
		int s = 0;
		for(int i = right-1; i>left; i--){
			s += Math.max(0, value-a[i]);  
		}
		return s;
	}
}

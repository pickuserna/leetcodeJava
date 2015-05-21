package trapwater;

import java.util.Stack;

/**
 * ������<>
 * @author zn
 * @CreateTime 2015-4-13����1:57:50
 */
public class TrappingWaterOptimize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		TrappingWaterOptimize twp = new TrappingWaterOptimize();
		int a[]  = {2,0,2};
		System.out.println(twp.trap(a));
	}

	public int trap(int[] A){
		// ջs �д�ſ��ܳ�Ϊǽ�� λ��
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		int sum = 0;
		for(int i=1; i<A.length; i++){
			//�������ܵ�ǽ����û��ǽ֮ǰ�����͵�ǽ����ǽ��ջ
			if(A[i] > A[i-1]){
				while(!s.empty() && A[s.peek()] < A[i]){
					s.pop();
				}
				s.push(i);
			}
		}
		//���ջs�е�ˮ��(�󲿵�ǽ)
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

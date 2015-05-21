package trapwater;

import java.util.Arrays;
import java.util.Stack;

/**
 * ������<��û����������������ʽ����ˮ�۵�����->ǽ����ˮ���·�->ˮ�������������ڵ�ˮ�����˵�ǽ��>
 * @author zn
 * @CreateTime 2015-4-13����12:46:37
 */
public class TrapWater2 {

	/**
	 * TODO:<>
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		TrapWater2 tw2 = new TrapWater2();
		int a[]  = {4,2,3};
		System.out.println(tw2.trap(a));
	}

	public int trap(int[] A){
	
		int leftIndex = 0;
		// ջs �д�ſ��ܳ�Ϊǽ�� λ��
		Stack<Integer> s = new Stack<Integer>();
		s.push(leftIndex);
		int sum = 0;
		for(int i=1; i<A.length; i++){
			//���һ����ͨ��ˮ��
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
			//�������ܵ�ǽ����û��ǽ֮ǰ�����͵�ǽ����ǽ��ջ
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

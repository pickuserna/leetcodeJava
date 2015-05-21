package trapwater;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.table.TableColumn;

/**
 * ������<>
 * @author zn
 * @CreateTime 2015-4-13����11:56:40
 */
public class TrappingWater {

	/**
	 * TODO:<>
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingWater tw = new TrappingWater();
		int a[]  = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(tw.trap(a));
	}
	private void fillWater(int[] a, int right, int left){
		for(int k=right-1; k>=left; k--){
			if(a[k]>=a[right]){
				Arrays.fill(a, k+1, right, a[right]);
			}
		}
	}
	public int trap(int[] A){
		int indexLeft = 0;
		Stack<Integer> s = new Stack<Integer>();
		int[] B = Arrays.copyOf(A, A.length);//B�� ����ˮ����ˮƽ��ĸ߶�ֵ����
		//�ҵ���һ����0��ǽ��������Բ�Ҫ
		int leftIndex = 0;
		//s.push(B[0]);
		//����ǽһֱ�� B[i]����ˮ����ˮ��
		for(int i=1; i<B.length; i++){
			//������ܿ�����ˮ��(������ǽ)��ô����ˮƽ�棺��׼������������
			if(B[i]>B[i-1]){
				//����һ����ͨ��ˮ��
				if(B[i] >= B[leftIndex]){
					Arrays.fill(B, leftIndex, i, B[leftIndex]);
					leftIndex = i;
				}
				//�����Գ���ˮ��,�����ҵ���B[i]��������ǽ����ˮ
				else{
					fillWater(B, i, leftIndex);
				}
			}
		}
		//����ˮ��ˮ��
		int sum = 0;
		for(int i=0; i<A.length; i++){
			sum += B[i] - A[i];
		}
		return sum;
	}

}

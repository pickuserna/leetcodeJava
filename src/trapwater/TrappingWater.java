package trapwater;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.table.TableColumn;

/**
 * 描述：<>
 * @author zn
 * @CreateTime 2015-4-13上午11:56:40
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
		int[] B = Arrays.copyOf(A, A.length);//B是 带有水槽里水平面的高度值集合
		//找到第一个非0的墙，这个可以不要
		int leftIndex = 0;
		//s.push(B[0]);
		//从左墙一直到 B[i]计算水槽容水量
		for(int i=1; i<B.length; i++){
			//如果可能可以容水，(更新左墙)那么设置水平面：标准，出现上升沿
			if(B[i]>B[i-1]){
				//充满一个连通的水槽
				if(B[i] >= B[leftIndex]){
					Arrays.fill(B, leftIndex, i, B[leftIndex]);
					leftIndex = i;
				}
				//不可以充满水槽,向左找到比B[i]大的最近的墙，填水
				else{
					fillWater(B, i, leftIndex);
				}
			}
		}
		//计算水槽水量
		int sum = 0;
		for(int i=0; i<A.length; i++){
			sum += B[i] - A[i];
		}
		return sum;
	}

}

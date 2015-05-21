package datastructure;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;

import tools.UtilMy;

//����ջ
public class MinStack<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack<Integer> ms = new MinStack<Integer>();
		ms.test();
	}

	public void test(){
		push(85);
		push(-99);
		push(67);
		UtilMy.print(getMin());
		UtilMy.print(getMin());
		UtilMy.print(getMin());
	}
	private final int InitialSize = 32;
	private int top = 0;// ջ��ָ��
	private int base = 0;// ջ��ַ
	
	Object[] elementsData = new Object[InitialSize];
	private int min = Integer.MAX_VALUE;
	private boolean isMinValid = false;
	// ȷ��n��������ջ
	private void ensureCapacity(int n) {
		if (n > elementsData.length) {
			int newLength = elementsData.length * 2;// ��2����
			newLength = Math.max(n, newLength);
			//Error
			elementsData = Arrays.copyOf(elementsData, newLength);
		}
	}
//!!Integer.getClass() != int.class
	public void push(Integer x) {
		ensureCapacity(top+1); 
		//�ڼ����ʱ�����min ֵ
		if(isMinValid && x<min){
			min = x;
		}
		elementsData[top++] = x;
	}

	public void pop() {
		if (top != base) {
			top--;
			//pop����С��ֵ����Сֵ ���Ϸ�
			if((Integer)elementsData[top]==min){
				min = Integer.MAX_VALUE;
				isMinValid = false;
			}
		}
	}

	public int top() {
		return (Integer)elementsData[top-1];
	}
	
	private int compare(Object a, Object b){
		int ia = (Integer) a;
		int ib = (Integer)b;
		return ia<ib?-1:(ia==ib?0:1);
	}
	public void printAll(){
		UtilMy.print("printAll:");
		for(int i=0; i<top; i++){
			UtilMy.print(elementsData[i]);
		}
	}
	//�����㷨��ȡminֵ
	public int getMin() {
		if(isMinValid){
			return min;
		}
		for(int i=0; i<top ; i++){
			if(compare(elementsData[i], min)<0){
				min = (Integer)elementsData[i];
			}
		}
		isMinValid = true;
		return min;
	}
}

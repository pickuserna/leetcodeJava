package datastructure;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;

import tools.UtilMy;

//链表栈
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
	private int top = 0;// 栈顶指针
	private int base = 0;// 栈基址
	
	Object[] elementsData = new Object[InitialSize];
	private int min = Integer.MAX_VALUE;
	private boolean isMinValid = false;
	// 确保n个容量的栈
	private void ensureCapacity(int n) {
		if (n > elementsData.length) {
			int newLength = elementsData.length * 2;// 乘2增长
			newLength = Math.max(n, newLength);
			//Error
			elementsData = Arrays.copyOf(elementsData, newLength);
		}
	}
//!!Integer.getClass() != int.class
	public void push(Integer x) {
		ensureCapacity(top+1); 
		//在加入的时候更新min 值
		if(isMinValid && x<min){
			min = x;
		}
		elementsData[top++] = x;
	}

	public void pop() {
		if (top != base) {
			top--;
			//pop了最小的值，最小值 不合法
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
	//遍历算法获取min值
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

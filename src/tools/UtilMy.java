package tools;

/**
 * 描述：<>
 * @author zn
 * @CreateTime 2015-4-14下午8:43:05
 */
public class UtilMy {

	/**
	 * TODO:<>
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void print(Object o){
		System.out.println(o);
	}
	//泛型
	//泛型多了类型检查
	//泛型确定时间：在赋值的时候
	public static <E>void printArray(E[] os){
		for(E e: os){
			print(e);
		}
	}
}

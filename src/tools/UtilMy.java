package tools;

/**
 * ������<>
 * @author zn
 * @CreateTime 2015-4-14����8:43:05
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
	//����
	//���Ͷ������ͼ��
	//����ȷ��ʱ�䣺�ڸ�ֵ��ʱ��
	public static <E>void printArray(E[] os){
		for(E e: os){
			print(e);
		}
	}
}

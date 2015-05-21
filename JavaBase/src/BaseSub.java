import java.lang.reflect.Field;

//����Base ��� Sub ���У�  �����˵���ķ��ʷ�ʽ
class Sub extends Base{
	String s = "sub";
	
	public String getS(){
		return this.s;
	}
	public String getBaseS(){
		return super.s;
	}
	//method invoke 
	//f1()->super.f1();
	public void f1(){
		System.out.println("Sub.f1()->");
		super.f1();
	}
	public void f2(){
		System.out.println("Sub.f2()->");
	}
}
class Base{
	protected String s= "base";
	//f1()-> f2();
	public void f1(){
		System.out.println("Base.f1()");
		this.f2();
		System.out.println("s = "+this.s);
	}
	
	public void f2(){
	
		System.out.println("Base.f2()");
		s = "";
	}
}
public class BaseSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fieldTest();
		methodTest();
		
	}
	//֤�� super.getS();�᷵��base�е�field,
	//super ֻ�������ڲ����ã� ������this
	public static void fieldTest(){
		Sub sub = new Sub();
		Base base = new Base();
		System.out.println("sub.getBaseS():	"+sub.getBaseS());//"base"
		System.out.println("sub.getS():	"+sub.getS());//"sub"
		Class c = Sub.class;
		for ( Field f :c.getDeclaredFields()){//getField : public field
			System.out.println(f.getName());
			try {
				f.get(base);//Error
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//���� ���� Sub.f1()->super.f1()->f2();�ĵ�����Ϊ
	//==����sub������֤�� ��sub�����У�����super��������super�������ñ����า���˵ĺ�������ô�����ʵ������ʵ������е��ã�����subʵ���ĺ���
	//==��Base������      �� ��super�з��ʱ����า���˵��� ��ô�����Base�е���
	//��ΪSub�а�����Super�ĵ�ַ�ռ�
	public static void methodTest(){
		Sub sub = new Sub();
		Base base = new Base();
		System.out.println("start");
		sub.f1();
		System.out.println("end");//sub.f1()Sub.f1()->Base.f1()Sub.f2(),     s = base
	}
	

}

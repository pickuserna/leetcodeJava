import java.lang.reflect.Field;

//测试Base 类和 Sub 类中，  覆盖了的域的访问方式
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
	//证明 super.getS();会返回base中的field,
	//super 只能在类内部引用， 类似于this
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
	
	//测试 调用 Sub.f1()->super.f1()->f2();的调用行为
	//==函数sub：：：证明 在sub函数中，调用super函数，在super函数调用被子类覆盖了的函数，那么会根据实例的真实情况进行调用，即：sub实例的函数
	//==域Base：：：      ， 在super中访问被子类覆盖了的域， 那么会访问Base中的域
	//因为Sub中包含了Super的地址空间
	public static void methodTest(){
		Sub sub = new Sub();
		Base base = new Base();
		System.out.println("start");
		sub.f1();
		System.out.println("end");//sub.f1()Sub.f1()->Base.f1()Sub.f2(),     s = base
	}
	

}

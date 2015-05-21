package datastructure;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import tools.UtilMy;

public class ReflectionTest {

	/**
	 * TODO:<>
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ReflectionTest rt = new ReflectionTest();
		MinStack<Integer> ms = new MinStack<Integer>();

//		rt.reflectMinStack(ms, "push", -3);
		rt.testEntrance(ms, "" +
		"push(2),push(0),push(3),push(0),getMin,pop,getMin,pop,getMin,pop,getMin"+
		"");
		ms.printAll();
		// ArrayList[] as = new ArrayList[2];
		// Array.newInstance(ArrayList.class, 12);
	}

	public void testEntrance(MinStack<Integer> ms, String s) throws Exception {
		String[] cmds = s.split(",");
		String mName = "";
		for (String c : cmds) {
			Object args = null;
			c = c.trim();//去除空白字符
			mName = c;
			// push 函数，提取和传递参数
			if (c.contains("push")) {
				int loc = c.lastIndexOf(")");
				mName = "push";
				args = Integer.valueOf(c.substring(5, loc));
			}
			reflectTest(ms, mName, args);
		}
	}

	public void reflectTest(Object obj, String methodName, Object... args) throws Exception {
		Class[] clses = new Class[args.length];
		Method method = null;
		if (args[0] != null) {
			for (int i = 0; i < args.length; i++) {
				clses[i] = args[i].getClass();
			}
			method = obj.getClass().getDeclaredMethod(methodName, clses);
		}
		else{
			method = obj.getClass().getDeclaredMethod(methodName);
		}
		// 打印数据
		if (methodName.equals("getMin") || methodName.equals("top")) {
			UtilMy.print(methodName+":"+method.invoke(obj));
		}
		else if(methodName.endsWith("pop")){
			method.invoke(obj);
		}
		else {
			method.invoke(obj, args);
		}
	}

	// 代理模式，使用反射进行设计
	public void reflectMinStack(MinStack ms, String name, int args) throws Exception {
		Method m = ms.getClass().getMethod(name, Integer.class);
		m.invoke(ms, args);
	}

	public void reflect() throws Exception {
		MinStack<Integer> ms = new MinStack<Integer>();
		// ms.base = 1000;
		for (Field f : ms.getClass().getDeclaredFields()) {
			UtilMy.print(f.getName() + ":" + f.isAccessible());
			f.setAccessible(true);
			if (f.getName().equals("top")) {
				f.set(ms, 12);
				// ms.base = 10;
			}
			UtilMy.print(f.get(ms));
		}
		// ms.top = 1;
	}
}

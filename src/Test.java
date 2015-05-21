import java.util.ArrayList;
import java.util.Arrays;

import tools.UtilMy;



public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println(get(12553));
		Integer a[] = new Integer[30];
		a = new Integer[2];
		ArrayList<;>
		//数组不具有协变性
		Arrays.fill(a, 12);
		UtilMy.printArray(a);
	}

	// 将一个数字abcde分成bcde和abcde
	public static int get(int n) {
		String s = String.valueOf(n);
		String sub = s.substring(1, s.length());
		int res = 0;
		// 0bcde+1到abcde的首位
		int first = Integer.parseInt(s.charAt(0) + "");
		if (first == 1) {
			if (!sub.equals("")) {
				res += Integer.parseInt(sub) + 1;
			}
		} else {
			res += power10(s.length() - 1);
		}
		if (!sub.equals("")) {
			// bcde+1到abcde除去首位之后，剩余的位置
			res += first * (s.length() - 1) * power10(s.length() - 2);
			// 1到bcde的
			res += get(Integer.parseInt(sub));
		}
		return res;
	}

	public static int power10(int n) {
		int r = 1;
		for (int i = 0; i < n; i++) {
			r *= 10;
		}
		return r;
	}
}
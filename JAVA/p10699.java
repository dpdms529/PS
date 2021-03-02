package baekjoon;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class p10699 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(f.format(c.getTime()));
	}

}

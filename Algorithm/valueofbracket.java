import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

	String replaced_strr;
	int indexstrr;
	int count = 0;
	int level = 0;
	int answer = 0;
	boolean chk = true;
	char[] array_s;
	List<Integer> lvl = new ArrayList<Integer>();
	List<Integer> values = new ArrayList<Integer>();


	public int bracketcount(String strr) {
		replaced_strr = strr;
		array_s = strr.toCharArray();
		while (chk) {
			replaced_strr = replaced_strr.replace("()", "");
			replaced_strr = replaced_strr.replace("[]", "");
			count++;
			if (replaced_strr.isEmpty()) break;
			else if (count == 15) return 0;
		}
		for (int i = 0; i < array_s.length; i++) {
			if(array_s[i] =='(') {
				try {
					if(array_s[i-1] == '(' || array_s[i-1] =='[') {

						level += 1;
						values.add(2);
						lvl.add( level);
					}else {

						values.add(2);
						lvl.add( level);
					}
				} catch (Exception e) {

					level += 1;
					values.add(2);
					lvl.add( level);
				}
			}
			else if(array_s[i] =='[') {
				try {
					if(array_s[i-1] == '(' || array_s[i-1] =='[') {

						level += 1;
						values.add(3);
						lvl.add( level);
					}else {

						values.add(3);
						lvl.add( level);
					}
				} catch (Exception e) {

					level += 1;
					values.add(3);
					lvl.add( level);
				}
			}
			else if (array_s[i] ==')'){
				try {
					if(array_s[i-1] == ')' || array_s[i-1] ==']') {

						level -= 1;
						values.add(0);
						lvl.add( level);
					}else {

						values.add(0);
						lvl.add( level);
					}
				} catch (Exception e) {

					level -= 1;
					values.add(0);
					lvl.add( level);
				}
			}
			else if (array_s[i] ==']'){
				try {
					if(array_s[i-1] == ')' || array_s[i-1] ==']') {

						level -= 1;
						values.add(0);
						lvl.add( level);
					}else {

						values.add(0);
						lvl.add( level);
					}
				} catch (Exception e) {

					level -= 1;
					values.add(0);
					lvl.add( level);
				}
			}
		}
		count = 1;

		while (count<=15) {
			indexstrr = lvl.indexOf(Collections.max(lvl));
			while(true) {
				try {
					if(lvl.get(indexstrr) == lvl.get(indexstrr + 1)) {
						answer += values.get(indexstrr);
						lvl.remove(indexstrr);
						values.remove(indexstrr);
					}
					else {
						lvl.remove(indexstrr);
						values.remove(indexstrr);
						values.add(indexstrr-1, values.get(indexstrr-1)*answer);
						values.remove(indexstrr);
						answer = 0;
						break;
					}
				} catch (Exception e) {
					break;
				}
			}
			count++;
		}
		return answer;
	}

	public static void main(String[] args) throws Exception, Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String qqq = bufferedReader.readLine();
        Main bracket = new Main();
		System.out.println(bracket.bracketcount(qqq));
	}

}

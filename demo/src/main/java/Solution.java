import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Result {

	public static String getShiftedString(String s, int leftShifts, int rightShifts) {

		int len = s.length();
		String str = null;
		
		leftShifts=leverageShift(leftShifts, len);
		str = leftRt(s, leftShifts);
		System.out.println("L str:" + str);

		
		rightShifts=leverageShift(rightShifts, len);
		str = rightRt(str, rightShifts);

		System.out.println("R str:" + str);

		return str;
	}

	private static int leverageShift(int shift,int len){

			while(shift>=len) {
				shift=shift%len;
			}
			System.out.println("shift modified:"+shift);
			return shift;
	}
	
	public static String leftRt(String s, int leftShift) {
		if(leftShift==s.length() || leftShift==0) {
			return s;
		}
		return s.substring(leftShift) + s.substring(0, leftShift);
	}

	public static String rightRt(String s, int rightShift) {
		return leftRt(s, s.length() - rightShift);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int leftShifts = Integer.parseInt(bufferedReader.readLine().trim());

		int rightShifts = Integer.parseInt(bufferedReader.readLine().trim());

		String result = Result.getShiftedString(s, leftShifts, rightShifts);

		// bufferedWriter.write(result);
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
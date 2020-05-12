package flentascoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test1 {

	public static void main(String args[]) throws Exception {
		// BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			long[] a = new long[n];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < n; i++)
				a[i] = Long.parseLong(st.nextToken());
			Arrays.sort(a);
			long res = 0;
			while (n > 3) {
				long op1 = a[0] + 2 * a[1] + a[n - 1];
				long op2 = 2 * a[0] + a[n - 2] + a[n - 1];
				res += Math.min(op1, op2);
				n -= 2;
			}
			if (n == 3)
				res += sum(a, 3);
			else if (n == 2)
				res += a[1];
			else
				res += a[0];
			System.out.println(res);
		}
	}

	public static long sum(long[] a, int k) {
		long sum = 0;
		for (int i = 0; i < k; i++) {
			sum += a[i];
		}
		return sum;
	}

}

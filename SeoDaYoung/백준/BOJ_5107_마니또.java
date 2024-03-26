import java.util.*;
import java.io.*;

public class BOJ_5107_마니또 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; ; i++) {
            Map<String, String> map = new HashMap<>(); // 마니또 관계 저장
            String[] arr = new String[20]; // 이름 저장
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                arr[j] = a;
                map.put(a, b);
            }

            String end; // end: 마니또 대상
            for (String start : arr) { // start: 마니또 탐색자
                end = map.get(start);

                while (true) {
                    end = map.get(end);

                    if (end == null)
                        break;
                    else if (end.equals(start)) { // 대상을 찾았을 때
                        cnt++;
                        map.keySet().remove(end);
                        break;
                    }
                }
            }
            System.out.println(i + " " + cnt);

            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
        }
    }
}

import java.io.*;
import java.util.*;

public class Main { // Boj_21736_헌내기는 친구가 필요해
    static int N, M, answer, start_x, start_y;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] arr;
    static boolean[][] visit;
    static final String sad_Message = "TT";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(arr[i][j] == 'I'){
                    start_x = i;
                    start_y = j;
                }
            }
        }
        bfs(start_x,start_y);
        if(answer == 0){
            System.out.println(sad_Message);
        }else{
            System.out.println(answer);
        }
    }

    public static void bfs(int x, int y) {
        visit = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visit[x][y] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int now_x = now[0];
            int now_y = now[1];

            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if (range_chk(next_x, next_y) && !visit[next_x][next_y] && arr[next_x][next_y] != 'X') {
                    que.add(new int[]{next_x, next_y});
                    visit[next_x][next_y] = true;
                    if(arr[next_x][next_y] == 'P'){
                        answer ++;
                    }
                }
            }
        }
    }

    public static boolean range_chk(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }
}
import java.io.*;
import java.util.*;

class Node{
	int x;
	int y;
	int dist;
	int boom;
	Node(int x, int y, int dist, int boom){
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.boom = boom;
	}
}

public class Main{

	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int n,m,ans;
	static boolean visit[][][];
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][2];
		ans = -1;

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs();
		
		System.out.println(ans);
			
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1,0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;
			
			if(x==n-1 && y == m-1) {
				ans = now.dist;
				return;
			}
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(0>nx || nx>=n || 0>ny || ny>=m) continue;
				
				if(map[nx][ny] == 0 && !visit[nx][ny][now.boom]) { //벽이 아닐경우
					visit[nx][ny][now.boom] = true;
					q.add(new Node(nx,ny,now.dist+1,now.boom));
				}else { //벽이 있는경우
					if(now.boom == 0 && !visit[nx][ny][now.boom+1]) { //벽을 부순적이 없을때
						visit[nx][ny][now.boom+1] = true;
						q.add(new Node(nx,ny,now.dist+1,now.boom+1));
					}
				}
				
			}
		}
		
	}
}
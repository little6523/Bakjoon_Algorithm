// import java.util.*;

// class Solution {
//     public int[] solution(String[] park, String[] routes) {
//         int[] answer = {};
        
//         int[] pos = {0, 0};
//         for (int i = 0; i < park.length; i++) {
//             for (int j = 0; j < park[i].length(); j++) {
//                 if (park[i].charAt(j) == 'S') {
//                     pos = new int[] {i, j};
//                 }
//             }
//         }
        
//         for (String route : routes) {
//             StringTokenizer st = new StringTokenizer(route);
//             String dir = st.nextToken();
//             int num = Integer.parseInt(st.nextToken());
//             pos = go(park, pos, dir, num);
//         }
//         answer = pos;
//         return answer;
//     }
    
//     public int[] go(String[] park, int[] pos, String dir, int num) {
//         int[] temp = new int[] {0, 0};
//         temp[0] = pos[0]; temp[1] = pos[1];
        
//         if (dir.equals("E")) {
//             temp[1] += num;
//             if (temp[1] >= park[0].length()) {
//                 return pos;
//             }            

//             if (park[temp[0]].charAt(temp[1]) == 'X') {
//                     return pos;
//             }
//         }
        
//         else if (dir.equals("S")) {
//             for (int i = 0; i < num; i++) {
//                 temp[0] += 1;
                
//                 if (temp[0] >= park.length) {
//                     return pos;
//                 }
                
//                 if (park[temp[0]].charAt(temp[1]) == 'X') {
//                     return pos;
//                 }
//             }
//         }
        
//         else if (dir.equals("W")) {
//             for (int i = 0; i < num; i++) {
//                 temp[1] -= 1;
//                 if (temp[1] >= park[0].length()) {
//                     return pos;
//                 }
                
//                 // if (park[temp[0]].charAt(temp[1]) == 'X') {
//                 //     return pos;
//                 // }
//             }
//         }
        
//         else if (dir.equals("N")) {
//             for (int i = 0; i < num; i++) {
//                 temp[0] -= 1;
//                 if (temp[0] >= park.length) {
//                     return pos;
//                 }
                
//                 // if (park[temp[0]].charAt(temp[1]) == 'X') {
//                 //     return pos;
//                 // }
//             }
//         }
        
//         return temp;
//     }
// }

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = -1;  //시작지점이자 최종 위치
        int y = -1;  //시작지점이자 최종 위치
        int height = park.length;   //공원 높이
        int weight = park[0].length();    //공원 넓이
        
        //공원 순회
        for(int i=0;i<park.length;i++){
            if(park[i].indexOf('S') != -1){
                x = park[i].indexOf('S');
                y = i;
                break;
            }
        }
        
        
        
        // 강아지 명령 순회
        for(int i=0;i<routes.length;i++){
            String[] temp = routes[i].split(" ");
            String vector = temp[0];        //방향
            int distance =  Integer.parseInt(temp[1]);  //거리
            int currX = x;
            int currY = y;
            
            if(vector.equals("E")){ //동
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currX++;
                    if(currX >= weight){	//범위를 벗어났나
                        flag = false;
                        break;
                    }
                    // 장애물이 있나
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                    x = currX;
                }
            }
            else if(vector.equals("W")){    //서
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currX--;
                    if(currX < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                        x = currX;
                }
            }
            else if(vector.equals("S")){    //남
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currY++;
                    if(currY >= height){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                        y = currY;
                }
            }
            else if(vector.equals("N")){    //북
                boolean flag = true;
                for(int j=1;j<=distance;j++){
                    currY--;
                    if(currY < 0){
                        flag = false;
                        break;
                    }
                    else if(park[currY].charAt(currX) =='X'){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag) {
                    y = currY;
                }
            }

        }
        
        answer[0] = y;
        answer[1] = x;
        
        return answer;
    }
}
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> cache = new LinkedList<>();
        
        String temp;
        for (int i = 0; i < cities.length; i++) {
            
            temp = cities[i].toUpperCase();
            // cache miss: 찾고자 하는 데이터가 캐시에 없는 경우
            if (!cache.contains(temp)) {
                answer += 5;
                
                if (cacheSize > 0) {
                    if (cache.size() == cacheSize) {
                        cache.poll();
                        cache.offer(temp);
                    }
                
                    else {
                        cache.offer(temp);
                    }
                }

            }
            
            // cache hit: 찾고자 하는 데이터가 캐시에 있는 경우
            else {
                answer += 1;
                cache.remove(temp);
                cache.offer(temp);
            }
        }
        
        return answer;
    }
}
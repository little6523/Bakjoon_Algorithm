class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int lux = wallpaper.length;;
        int luy = wallpaper[0].length();
        int rdx = -1;
        int rdy = -1;
        
        for(int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (i < lux) {
                        lux = i;
                    }
                    
                    if (j < luy) {
                        luy = j;
                    }
                    
                    if (i > rdx) {
                        rdx = i;
                    }
                    
                    if (j > rdy) {
                        rdy = j;
                    }
                }
            }
        }
        
        return new int[] {lux, luy, rdx + 1, rdy + 1};
    }
}
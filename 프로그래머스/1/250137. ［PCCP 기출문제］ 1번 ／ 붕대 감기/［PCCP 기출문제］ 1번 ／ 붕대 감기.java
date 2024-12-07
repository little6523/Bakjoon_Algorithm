class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int count = 0;
        int max_health = health;
        int size = attacks.length;
        boolean isDie = false;
        
        for (int i = 1; i <= attacks[size-1][0]; i++) {
            boolean isAttack = false;
            for (int[] attack : attacks) {
                if (i == attack[0]) {
                    isAttack = true;
                    health -= attack[1];
                    count = 0;
                }
                
                if (health <= 0) {
                    isDie = true;
                    break;
                }
            }
            
            if (isDie) {
                break;
            }
            
            if (!isAttack && health < max_health) {
                health += bandage[1];
                count++;
            
                if (count == bandage[0]) {
                    health += bandage[2];
                    count = 0;
                }
                
                if (health > max_health) {
                    health = max_health;
                }
            }
            
        }
        
        if (isDie) {
            answer = -1;
        } else {
            answer = health;
        }

        return answer;
    }
}
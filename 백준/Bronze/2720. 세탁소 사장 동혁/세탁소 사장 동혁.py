T = int(input())

# 쿼터: $0.25 => 25센트
# 다임: $0.10 => 10센트
# 니켈: $0.05 =>  5센트
# 페니: $0.01 =>  1센트
money = [25, 10, 5, 1]
for _ in range(T):
    n = int(input())
    answer = [0] * 4
    
    for i in range(4):
        answer[i] = n // money[i]
        n %= money[i]
    
    for ans in answer:
        print(ans, end=' ')
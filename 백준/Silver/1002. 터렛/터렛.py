import math

T = int(input())

result = []

for _ in range(T):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    
    x_distance = (x2 - x1) ** 2
    y_distance = (y2 - y1) ** 2
    distance = math.sqrt(x_distance + y_distance)
    sum_r = r1 + r2
    
    if x1 == x2 and y1 == y2 and r1 != r2: # 중점 일치, 반지름 다름 => 0
        result.append(0)
    elif x1 == x2 and y1 == y2 and r1 == r2: # 중점 일치, 반지름 일치 => -1
        result.append(-1)
    
    elif distance > sum_r or distance < abs(r2-r1):
        result.append(0)
    elif distance == sum_r or distance == abs(r2-r1):
        result.append(1)
    elif distance < sum_r:
        result.append(2)
        
for i in range(T):
    print(result[i])
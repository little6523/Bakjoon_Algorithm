import sys
input = sys.stdin.readline

n = int(input())

in_car  = [input().rstrip() for _ in range(n)]
out_car = [input().rstrip() for _ in range(n)]
answer = 0
s = 0

for i in range(n):
    if in_car[i] == 'x': continue
    else:
        q = []
        for j in range(s, n):
            if in_car[i] != out_car[j]:
                q.append(out_car[j])
            else:
                answer += len(q)
                s = j+1
                break
        
        for j in range(n):
            if in_car[j] in q:
                in_car[j] = 'x'
                
print(answer)
import sys
input = sys.stdin.readline

T = int(input())
answer = []
for _ in range(T):
    r, s = map(str, input().rstrip().split())
    r = int(r)
    
    new_s = ''
    for i in range(len(s)):
        for _ in range(r):
            new_s += s[i]
    
    answer.append(new_s)
            
for ans in answer:
    print(ans)
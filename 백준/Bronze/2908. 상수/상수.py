import sys
input = sys.stdin.readline

a, b = map(str, input().rstrip().split())
answer = 0
rev_a, rev_b = int(a[::-1]), int(b[::-1])
if rev_a > rev_b:
    answer = rev_a
else:
    answer = rev_b
    
print(answer)
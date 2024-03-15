import sys
input = sys.stdin.readline

T = int(input())
for i in range(T):
    s = input().rstrip()
    print(s[0], s[-1], sep='')
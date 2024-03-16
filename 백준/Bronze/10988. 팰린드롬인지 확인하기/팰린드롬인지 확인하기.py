import sys
input = sys.stdin.readline

s = list(map(str, input().rstrip()))
if s == s[::-1]: print(1)
else: print(0)
n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]
background = [[0] * 100 for _ in range(100)]

for i in range(n):
    for j in range(paper[i][0], paper[i][0] + 10):
        for k in range(paper[i][1], paper[i][1] + 10):
            background[j][k] = 1
            
answer = 0
for i in range(100):
    for j in range(100):
        if background[i][j] == 1:
            answer += 1
            
print(answer)
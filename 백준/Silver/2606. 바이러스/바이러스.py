N = int(input())  # N <= 100

pair = int(input())  # 쌍의 개수(간선 개수)

edge = [list(map(int, input().split())) for _ in range(pair)]

graph = [[] for _ in range(N+1)]

for i in range(pair):
    graph[edge[i][1]].append(edge[i][0])
    graph[edge[i][0]].append(edge[i][1])

visited = [False] * (N+1)

def dfs(graph, v, visited):
    visited[v] = True
    
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

dfs(graph, 1, visited)

count = 0

for i in range(len(visited)):
    if visited[i] == True:
        count += 1
        
print(count-1)
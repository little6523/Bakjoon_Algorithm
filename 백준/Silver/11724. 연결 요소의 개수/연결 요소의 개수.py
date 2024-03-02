from collections import deque
import sys

n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]

for i in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)
    
def bfs(graph, start, visited):
    if visited[start]:
        return False
    
    queue = deque([start])
    visited[start] = True
    
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
    
    return True
                
visited = [False] * (n+1)

count = 0

for i in range(1, n+1):
    if bfs(graph, i, visited) == True:
        count += 1
        
print(count)
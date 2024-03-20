tri = list(map(int, input().split()))
tri.sort(reverse=True)

if tri[0] >= tri[1] + tri[2]:
    tri[0] = tri[1] + tri[2] - 1
    
print(sum(tri))
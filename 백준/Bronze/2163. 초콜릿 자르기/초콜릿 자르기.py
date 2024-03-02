N_By_M = input().split(' ')
N_By_M[0] = int(N_By_M[0])
N_By_M[1] = int(N_By_M[1])

# N-1 + (M-1) x N

Min_Div = (N_By_M[0]-1) + ((N_By_M[1]-1) * N_By_M[0])

print(Min_Div)
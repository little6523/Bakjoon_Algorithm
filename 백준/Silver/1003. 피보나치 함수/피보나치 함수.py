test_case = int(input())

answer = []

dp_zero  = [0] * 41
dp_one = [0] * 41

dp_zero[0] = 1
dp_one[1] = 1

for T in range(test_case):
    N = int(input())

    for i in range(2, N+1):
        dp_zero[i] = dp_zero[i-2] + dp_zero[i-1]
        dp_one[i] = dp_one[i-2] + dp_one[i-1]

    answer.append([dp_zero[N], dp_one[N]])

for T in range(test_case):
    print(answer[T][0], answer[T][1])
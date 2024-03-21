n, m = map(int, input().split())
card = list(map(int, input().split()))
answer = 0

for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            card_sum = card[i] + card[j] + card[k]
            if card_sum <= m and card_sum > answer:
                answer = card_sum
                
print(answer)
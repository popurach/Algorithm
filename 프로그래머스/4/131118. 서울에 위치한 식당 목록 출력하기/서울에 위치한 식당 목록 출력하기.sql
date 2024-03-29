-- 코드를 입력하세요
# DESC REST_INFO
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(SUM(R.REVIEW_SCORE)/COUNT(*), 2) SCORE
FROM REST_INFO I
    INNER JOIN REST_REVIEW R
    ON I.REST_ID = R.REST_ID
WHERE ADDRESS LIKE '서울%'
GROUP BY R.REST_ID
ORDER BY SCORE DESC, I.FAVORITES DESC












# SELECT A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS, ROUND(AVG(B.REVIEW_SCORE), 2) SCORE
# FROM REST_INFO A
#     INNER JOIN REST_REVIEW B 
#     ON A.REST_ID = B.REST_ID
# WHERE A.ADDRESS LIKE '서울%'
# GROUP BY B.REST_ID
# ORDER BY SCORE DESC, FAVORITES DESC

# SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(R.REVIEW_SCORE), 2) SCORE
# FROM REST_REVIEW R
#     INNER JOIN REST_INFO I
#     ON R.REST_ID = I.REST_ID
# WHERE I.ADDRESS LIKE "서울%"
# GROUP BY R.REST_ID
# ORDER BY 6 DESC, 4 DESC

# SELECT A.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE), 2) SCORE 
# FROM REST_INFO A RIGHT JOIN REST_REVIEW B
# ON A.REST_ID = B.REST_ID
# WHERE ADDRESS LIKE '서울%'
# GROUP BY A.REST_ID
# ORDER BY SCORE DESC, FAVORITES DESC
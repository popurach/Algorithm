-- 코드를 입력하세요
# SELECT FLAVOR
# FROM (
#     SELECT * FROM FIRST_HALF
#     UNION ALL
#     SELECT * FROM JULY
# ) A
# GROUP BY FLAVOR
# ORDER BY SUM(TOTAL_ORDER) DESC
# LIMIT 3

SELECT F.FLAVOR
FROM FIRST_HALF F 
    INNER JOIN JULY J
    ON F.FLAVOR = J.FLAVOR
GROUP BY FLAVOR
ORDER BY SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC
LIMIT 3
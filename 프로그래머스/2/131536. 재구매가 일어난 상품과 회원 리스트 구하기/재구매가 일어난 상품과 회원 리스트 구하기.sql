-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID, PRODUCT_ID DESC

# SELECT DISTINCT S1.USER_ID, S1.PRODUCT_ID
# FROM ONLINE_SALE S1
#     INNER JOIN ONLINE_SALE S2
#     ON S1.USER_ID = S2.USER_ID AND S1.PRODUCT_ID = S2.PRODUCT_ID
# WHERE S1.SALES_DATE != S2.SALES_DATE
# ORDER BY S1.USER_ID, S1.PRODUCT_ID DESC
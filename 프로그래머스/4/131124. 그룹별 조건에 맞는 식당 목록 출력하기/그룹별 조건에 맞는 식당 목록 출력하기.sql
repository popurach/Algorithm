# -- 코드를 입력하세요
# SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
# FROM MEMBER_PROFILE P
#     INNER JOIN REST_REVIEW R
#     ON P.MEMBER_ID = R.MEMBER_ID
# WHERE P.MEMBER_ID = (
#     SELECT MEMBER_ID
#     FROM REST_REVIEW
#     GROUP BY MEMBER_ID
#     ORDER BY COUNT(*) DESC
#     LIMIT 1
# )
# ORDER BY REVIEW_DATE, R.REVIEW_TEXT

# SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
# FROM MEMBER_PROFILE P
#     INNER JOIN REST_REVIEW R
#     ON P.MEMBER_ID = R.MEMBER_ID
# WHERE P.MEMBER_ID in (
#     SELECT * 
#     FROM (
#         SELECT MEMBER_ID
#         FROM REST_REVIEW
#         GROUP BY MEMBER_ID
#         ORDER BY COUNT(*) DESC
#         LIMIT 1
#     ) TMP
# )
# ORDER BY REVIEW_DATE, R.REVIEW_TEXT

SELECT P.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
FROM MEMBER_PROFILE P
    INNER JOIN REST_REVIEW R
    ON P.MEMBER_ID = R.MEMBER_ID
WHERE P.MEMBER_ID = (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
ORDER BY R.REVIEW_DATE
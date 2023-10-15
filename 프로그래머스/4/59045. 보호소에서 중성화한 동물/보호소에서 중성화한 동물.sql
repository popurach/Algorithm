-- 코드를 입력하세요
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I
    INNER JOIN ANIMAL_OUTS O
    ON I.ANIMAL_ID = O.ANIMAL_ID
# WHERE (I.SEX_UPON_INTAKE LIKE 'Intact%') AND 
#     (O.SEX_UPON_OUTCOME LIKE 'Neutered%' OR O.SEX_UPON_OUTCOME LIKE 'Spayed%')
WHERE I.SEX_UPON_INTAKE REGEXP ('^Intact') AND
    O.SEX_UPON_OUTCOME REGEXP ('Neutered|Spayed')
ORDER BY I.ANIMAL_ID
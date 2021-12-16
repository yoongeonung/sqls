SELECT
    ANIMAL_TYPE,
    COUNT(ANIMAL_TYPE) AS 'count'
FROM
    ANIMAL_INS
GROUP BY
    ANIMAL_TYPE
ORDER BY
    ANIMAL_TYPE;

# Group by는 분명히 조건에 따른 집계된값을 중복없이 정렬된값을 제공.
# 하지만 프로그래머스에서는 order by가 들어가지 않으면 틀린것으로 나온다.

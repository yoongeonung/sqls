# MIN()
SELECT
    NAME
FROM
    ANIMAL_INS
WHERE
    DATETIME = (
    SELECT MIN(DATETIME) FROM ANIMAL_INS
        );

# ORDER BY + LIMIT
SELECT
    name
FROM
     animal_ins
WHERE
      datetime =
      (
          SELECT
                 datetime
          FROM
               animal_ins
          ORDER BY
                   datetime
          LIMIT 1
    );

# NO SUBQUERY
select
    name
from
    animal_ins
order by datetime
limit 1;

# 결론
# MIN() 함수를 사용하는게 알기쉬우며 유지보수 관점, 성능면에서도 좋다
# https://stackoverflow.com/questions/426731/min-max-vs-order-by-and-limit

Create emp table:
```sql
CREATE TABLE employee(
    eid INT,
    name VARCHAR(20),
    designation VARCHAR(20),
    salary INT
);
```

Change EID Type to String
```sql
ALTER TABLE employee ALTER COLUMN eid VARCHAR(20);
```

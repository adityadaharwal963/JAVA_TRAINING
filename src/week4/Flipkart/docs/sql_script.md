
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

---
Insert
```sql
INSERT INTO employee VALUES ('E001','SAM','CEO',1000000);
INSERT INTO employee VALUES ('E002','RAM','CFO',1000000);
INSERT INTO employee VALUES ('E003','DAM','CTO',1000000);
INSERT INTO employee VALUES ('E004','PAM','CMO',1000000);

```

---

```sql
TRUNCATE TABLE employee;
```


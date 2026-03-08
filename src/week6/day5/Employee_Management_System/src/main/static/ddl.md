```sql
CREATE TABLE Users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(20) UNIQUE,
    password VARCHAR(20) NOT NULL,
    role  VARCHAR(10)
)
```

```sql
CREATE TABLE Employee(
    id INTEGER REFERENCES Users(id),
    name VARCHAR(20),
    email VARCHAR(20) NOT NULL,
    phone  VARCHAR(10),
    address  VARCHAR(50),
    department  VARCHAR(20),
    city  VARCHAR(20),
    designation  VARCHAR(20),
    gender  VARCHAR(6),
    salary DOUBLE PRECISION 
)
```

```sql
INSERT INTO Users (username,password,role) VALUES ('admin','1234','employer');
```

```sql
INSERT INTO Users (username,password,role) VALUES (?,?,?);
```

```sql
INSERT INTO Employee (id, name, email, phone, address, department, city, designation, gender, salary) VALUES (?,?,?,?,?,?,?,?,?,?);
```
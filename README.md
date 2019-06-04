# connecting_slick_with_psql


- This repository is designed to provide a base for using Slick with psql driver.
- Shows how to set up a project using slick version 3.3.0. 

## Guide 

1. Ensure the PostgreSql db is running on your

```
psql <database_name>
```

2. Run the SQL scripts via the `psql` command line tool 

```
psql create_table.sql 
psql insert_users.sql
```

3. Run the Main class

## References 

1. http://queirozf.com/entries/scala-slick-simple-example-on-connecting-to-a-postgresql-database
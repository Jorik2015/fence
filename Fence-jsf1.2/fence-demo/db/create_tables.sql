connect 'jdbc:derby:db/fence-demo;create=true';
create table login_user (
    id integer primary key, 
    name varchar(50), 
    customer_since date
);
insert into login_user (id, name, customer_since) 
  values
    (1, 'Rod', '2003-01-01'),
    (2, 'Adrian', '2005-10-15');

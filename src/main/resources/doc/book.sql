create table book(
    id int(11) primary key auto_increment,
    name varchar(128) default NULL,
    author varchar(64) default NULL
);

insert into book(id, name, author) values(1, '三国演义', '罗贯中'),(2, '水浒传', '施耐庵');
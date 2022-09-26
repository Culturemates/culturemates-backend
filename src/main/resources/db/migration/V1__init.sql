create table movie_list (
    id bigint not null auto_increment,
    movie_name varchar(100) not null,
    create_year varchar(10),
    create_country varchar(100),
    type varchar(64),
    genre varchar(64),
    create_status varchar(64),
    director varchar(100),
    imgurl varchar(256),
    user_rating float() precision,
    primary key (id)
);
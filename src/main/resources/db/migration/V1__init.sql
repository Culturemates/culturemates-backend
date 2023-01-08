create table movie_list (
    id bigint not null auto_increment,
    create_country varchar(255),
    create_status varchar(255),
    create_year int,
    director varchar(255),
    genre varchar(255),
    imgurl varchar(255),
    movie_name varchar(255),
    type varchar(255),
    user_rating float,
    movie_cd varchar(255),
    movie_en_name varchar(255),
    open_year int,
    movie_code varchar(255),
    screen_end_period int,
    screen_start_period int,
    primary key (id)
) engine=InnoDB;
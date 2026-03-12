create table instructors
(
    id        bigint auto_increment
        primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null
);

create table events
(
    id            bigint auto_increment
        primary key,
    start_time    DATETIME     not null,
    end_time      DATETIME     not null,
    title         varchar(255) not null,
    description   varchar(255) not null,
    instructor_id bigint       not null,
    constraint events_instructors_id_fk
        foreign key (instructor_id) references instructors (id)
);


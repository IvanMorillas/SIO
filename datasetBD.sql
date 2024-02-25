DROP DATABASE dataset;

CREATE DATABASE dataset;

USE dataset;

CREATE TABLE persons(
	person_id int not null unique primary key,
    title_id varchar(255) not null,
    person_name varchar(255) not null,
    person_character varchar(255),
    person_role varchar(255) not null
);

CREATE TABLE titles(
	title_id varchar(255) not null unique primary key,
    title varchar(255) not null,
    title_type varchar(255) not null,
    title_description text,
    title_release_year int,
    title_age_certification varchar(255),
    title_runtime int,
    title_seasons float, 
    title_imdb_id varchar(255),
    title_imdb_score float,
    title_imdb_votes float,
    title_tmdb_popularity float,
    title_tmdb_score float
);

CREATE TABLE roles (
    role_id int auto_increment primary key,
    role_name varchar(255) not null unique
);

CREATE TABLE title_person (
    person_id int not null,
    title_id varchar(255) not null,
    role_id int not null,
    primary key (person_id, title_id, role_id),
    foreign key (person_id) references persons(person_id),
    foreign key (title_id) references titles(title_id),
    foreign key (role_id) references roles(role_id)
);

CREATE TABLE genres (
	genre_id int auto_increment primary key,
    genre_name varchar(255) not null unique
);

CREATE TABLE titles_genres (
	title_id varchar(255) references title(title_id),
    genre_id int references genres(genre_id),
    primary key (title_id, genre_id)
);

CREATE TABLE countries (
	country_id int auto_increment primary key,
    country_name varchar(255) not null unique
);

CREATE TABLE titles_countries (
	title_id varchar(255) references title(title_id),
    country_id int references countries(country__id),
    primary key (title_id, country_id)
);

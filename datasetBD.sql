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

CREATE TABLE title_person (
    person_id int not null,
    title_id varchar(255) not null,
    primary key (person_id, title_id),
    foreign key (person_id) references persons(person_id),
    foreign key (title_id) references titles(title_id)
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

-- INSERT INTO genres (genre_name) VALUES
-- ('Horror'),
-- ('Action');

-- INSERT INTO countries (countrie_name) VALUES
-- ('ESP');

-- INSERT INTO persons (person_id, title_id, person_name, person_character, person_role) 
-- VALUES (59400, 'ts20945', "John Doe", "John", "ACTOR");

-- INSERT INTO titles (title_id, title, title_type, 
-- title_description, title_release_year, title_age_certification,
-- title_runtime, title_seasons, title_imdb_id, title_imdb_score, 
-- title_imdb_votes, title_tmdb_popularity, title_tmdb_score) VALUES
-- ('ts20945','The Three Stooges','SHOW', 'The Three Stooges were an American vaudeville.',
-- 1934,'TV-PG',19,26.0,'tt0850645', 8.6, 1092.0, 15.424, 7.6);

-- INSERT INTO title_person (person_id, title_id) VALUES (59400, 'ts20945');

-- INSERT INTO titles_genres (title_id, genre_id) VALUES
-- ((select title_id from titles where title = 'The Three Stooges'), 
-- (select genre_id from genres where genre_name = 'Horror')),
-- ((select title_id from titles where title = 'The Three Stooges'), 
-- (select genre_id from genres where genre_name = 'Action'));

-- INSERT INTO titles_countries (title_id, countrie_id) VALUES
-- ((select title_id from titles where title = 'The Three Stooges'), 
-- (select countrie_id from countries where countrie_name = 'ESP'));
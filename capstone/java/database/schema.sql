BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS body_group;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS workout;
DROP TABLE IF EXISTS workout_exercise;
DROP TABLE IF EXISTS workout_history;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	email varchar(200) NOT NULL UNIQUE,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE body_group(
    body_group_id SERIAL,
    focus varchar (100) NOT NULL UNIQUE,
    CONSTRAINT PK_body_group PRIMARY KEY (body_group_id)
);
CREATE TABLE exercise (
    exercise_id SERIAL,
    body_group_id int NOT NULL,
    exercise_name varchar (100) NOT NULL UNIQUE,
    description varchar (500) NOT NULL,
    CONSTRAINT PK_exercise PRIMARY KEY (exercise_id),
    CONSTRAINT FK_exercise_body_group FOREIGN KEY (body_group_id) REFERENCES body_group (body_group_id)
);

CREATE TABLE workout (
    workout_id SERIAL,
    exercise_id int NOT NULL,
    body_group_id int NOT NULL,
    workout_name varchar(200) NOT NULL UNIQUE,
    sets int NOT NULL,
    reps int NOT NULL,
    duration int NOT NULL,
    CONSTRAINT pk_workout PRIMARY KEY (workout_id),
    CONSTRAINT FK_workout_body_group FOREIGN KEY (body_group_id) REFERENCES body_group (body_group_id),
    CONSTRAINT FK_workout_exercise FOREIGN KEY (exercise_id) REFERENCES exercise (exercise_id)
);
CREATE TABLE workout_exercise (
    workout_id int NOT NULL,
    exercise_id int NOT NULL,
    CONSTRAINT PK_workout_exercise PRIMARY KEY (workout_id,exercise_id),
    CONSTRAINT FK_workout_exercise_workout FOREIGN KEY (workout_id) REFERENCES workout (workout_id),
    CONSTRAINT FK_workout_exercise_exercise FOREIGN KEY (exercise_id) REFERENCES exercise (exercise_id)
);
CREATE TABLE workout_history (
    workout_history_id SERIAL,
    workout_id int NOT NULL,
    user_id int NOT NULL,
    duration int NOT NULL,
    workout_date date NOT NULL,
    CONSTRAINT PK_workout_history PRIMARY KEY (workout_history_id),
    CONSTRAINT FK_workout_history_workout FOREIGN KEY (workout_id) REFERENCES workout (workout_id),
    CONSTRAINT FK_workout_history_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);
COMMIT TRANSACTION;

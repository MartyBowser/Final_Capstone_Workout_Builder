BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, first_name, last_name, email) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'John', 'Smith', 'JohnSmith@gmail.com');
INSERT INTO users (username,password_hash,role, first_name, last_name, email) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'Joe', 'Brown', 'Joebrown@gmail.com');

INSERT INTO body_group (focus)
VALUES ('cardio');

INSERT INTO body_group (focus)
VALUES ('back');

INSERT INTO body_group (focus)
VALUES ('legs');

INSERT INTO body_group (focus)
VALUES ('arms');

INSERT INTO body_group (focus)
VALUES ('abs');


INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('1', 'High Knees', 'Bring your knees to your chest repeatedly');
INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('1', 'Jumping Jacks', 'Jump up and clap your hands!');

INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('2', 'Lat Pulldowns', 'Pull the bar down toward your chest');
INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('2', 'Reverse Flyes', 'Lay on your chest and lift the dumbbells up to your sides');
INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('3', 'Squats', 'Crouch down and then stand back up');
INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('3', 'Lunges', 'Pretend you''re walking forward in a silly way but then step back');

INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('4', 'Curls', 'Hold something heavy and pump those biceps');
INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('4', 'Skull Crushers', 'Lay on your back and lower the bar toward your face');

INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('5', 'Planks', 'Prop yourself up parallel to the floor and hold til it burns');
INSERT INTO exercise (body_group_id, exercise_name, description)
VALUES ('5', 'Deadlifts', 'Lift with your back, not with your legs!');



COMMIT TRANSACTION;

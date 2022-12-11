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

INSERT INTO body_group (focus)
VALUES ('fullbody');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'High Knees', 'Bring your knees to your chest repeatedly', '5', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Jumping Jacks', 'Jump up and clap your hands!', '5', '0', '3', '2');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'Lat Pulldowns', 'Pull the bar down toward your chest', '5', '60', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'Reverse Flyes', 'Lay on your chest and lift the dumbbells up to your sides', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Squats', 'Crouch down and then stand back up', '5', '100', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Lunges', 'Pretend you''re walking forward in a silly way but then step back', '5', '30', '3', '2');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Curls', 'Hold something heavy and pump those biceps', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Skull Crushers', 'Lay on your back and lower the bar toward your face', '5', '30', '3', '2');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Planks', 'Prop yourself up parallel to the floor and hold til it burns', '5', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Situps', 'Lay on your back and lift your torso!', '5', '40', '3', '2');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Deadlifts', 'Hips hinge backward to lower down and pick up a weighted barbell or Kettle bell from the floor', '5', '45', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Single Arm Dumbbell Bench Press ', 'Lie on a flat bench and hold a dumbbell in one hand, extending your arm until its straight and the weight is in line with your shoulder. Slowly lower to your chest and repeat', '5', '35', '3', '2');

COMMIT TRANSACTION;

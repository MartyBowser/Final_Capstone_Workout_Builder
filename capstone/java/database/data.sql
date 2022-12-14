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
VALUES ('1', 'Classic Burpee', 'Step 1: Start with your feet hip-width apart, standing tall. Jump into the air.' ||
                                'Step 2: lower your hands to the ground, and hop your legs back into plank position.'||
                                'Step 3: Immediately hop your legs forward so that your in a crouching position.'||
                                'Step 4: From here, jump straight into the air.'||
                                'Step 4: Repeat this sequence.', '60', '0', '3', '2');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Jump Squat', ' Step 1: Stand with your feet shoulder-width apart and the toes pointing slightly outward.'||
                             'Step 2: Bend your knees pressing your hips back as if you were going to sit back on a chair.'||
                             'Step 3: Pushing through the heels, jump straight up.'||
                             'Step 4: Land with your knees slightly bent and go back into the squat position.', '5', '0', '5', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Up Down Plank', 'Step 1: Start in a plank position, with your wrists under your shoulders and your feet hip-width apart.'||
                               'Step 2: Bend your left arm, place your left elbow on the mat and then bend your right arm and place your right elbow on the mat.'||
                               'Step 3: Place your left hand on the mat, straighten your left arm and then place your right hand on the mat and straighten your right arm.'||
                               'Step 4 Switch sides and repeat this up and down movement until the set is complete.', '60', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Lateral Bunny Hops', 'Step 1: Start with your feet together.'||
                                    'Step 2: Pretend there is an invisible line at your side.'||
                                    'Step 3: Using your arms for momentum, quickly jump side to side over the line.'||
                                    'Step 4: Keep your legs close together during this exercise.!', '60', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Split Lunge Jumps', 'Step 1: Stand with your feet together with soft knees.'||
                                   'Step 2: Get into a lunge position first and then continue with a jump. Land in an opposite lunge (if you began with the right foot forward, land with the left foot forward).'||
                                   'Step 3: Quickly jump back up and into the starting position with your feet together.'||
                                   'Step 4 Repeat on the other side.', '60', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Skaters', 'Step 1: Stand with your feet hip-width apart. Knees should be slightly bent.'||
                         'Step 2: Jump to the right with your right foot. Sweep the left foot behind your right leg.'||
                         'Step 3: Tap your right foot with your left hand.'||
                         'Step 4: Alternate sides by jumping to the left with your left foot while the right foot sweeps behind you. Tap your left foot with your right hand.'||
                         'Step 5: Use your arms to help keep the momentum.', '60', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Woodchops', 'Step 1: Start with your hands together towards your right side. Hold them about eye-level so your arms are bent at the elbows.'||
                           'Step 2: Put your weight on your right foot with the left foot slightly raised.'||
                           'Step 3: As if you were holding an axe, chop your arm across your body with bent knees. Transition your weight from your right to left foot, slightly raising your right foot at the end of the exercise.'||
                           'Step 4: You should be in a slight lunge position.'||
                           'Step 5: Bring your arms back to the starting position.'||
                           'Step 6: Repeat for your left side.!', '60', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('1', 'Mountain climbers', 'Step 1: Begin on your hands and knees.'||
                                   'Step 2: Position yourself in a high plank position with your core engaged. Make sure your lower back is not bowed.'||
                                   'Step 3: Bring your right foot up towards your right hand until you reach a lunge position.'||
                                   'Step 4: Quickly jump and switch your feet, so that the left foot is now in front.'||
                                   'Step 5: Continue this alternating pattern.', '60', '0', '3', '2');


INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'Lat Pulldowns', 'Pull the bar down toward your chest', '5', '60', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'Reverse Flyes', 'Lay on your chest and lift the dumbbells up to your sides', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'Back Extension', 'Step 1: Lie on a mat on your stomach and straighten your legs behind you.'||
                                'Step 2: Place your elbows on the ground and slide your shoulders down.'||
                                'Step 3: Lift your upper back, pressing your hips into the mat. Keep your head and neck neutral. Hold for 30 seconds.'||
                                'Step 4: Lower to starting position', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'FRONT PLANK HIP EXTENSIONS',  'Step 1:Begin on your knees and then lean forward and place both palms on the ground. Move to prop your upper body on your elbows rather than your hands.'||
                                            'Step 2: Stack your elbows directly beneath your shoulders and maintain a 90-degree angle in your elbow. Kick your legs out behind you so that your lower body is supported on your toes. Your feet should be between hip and shoulder-width apart.'||
                                            'Step 3: You need a straight line from your neck to your glutes. Pull your shoulder blades together to make sure your spine isn’t sinking or bulging.'||
                                            'Step 4: Now that you’re in the plank position, engage your back and core to maintain it.'||
                                            'Step 5 Raise either foot into the air so that the knee on that side is at 90 degrees. Extend it without moving your foot toward your glutes at all - that 90 degrees is supposed to hold. Slowly lower back to its original height to complete one rep.'||
                                            'Step 6: Continue for 10 - 15 reps on one side and then rest for 30 seconds before repeating the same number of reps raising the opposite leg.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'Superman', ' Step 1: Lie on your stomach on a flat surface and raise both your arms and your legs at the same time as though you are flying.'||
                           'Step 2: Hold the position for five seconds.'||
                           'Step 3: Then repeat 10 times.', '5', '30', '10', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'REVERSE HYPEREXTENSIONS', 'Step 1: lie your upper body across the table or bench starting with your core and ending at the pecs. Reach out and grab the end of the table or bench to keep yourself in place.'||
                                         'Step 2: Spread your feet about hip-width apart and then raise them both behind you. Squeeze your glutes and make sure those feet pass the height of your torso. You should feel a slight bend in your lower back.'||
                                         'Step 3: Hold for a brief pause and then slowly lower your feet. Don’t bring them all the way down to the floor. Count one rep when they’re an inch or two above and then lift them into the next repetition. ', '5', '100', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'DIY GLUTE HAM RAISE', 'Step 1: Stick your feet beneath a low horizontal bar, footstool, couch, or into your DIY contraption.'||
                                     'Step 2: Place your knees on a mat or other cushion, then lean forward a bit to put tension on your hamstrings.'||
                                     'Step 3: Keep your back straight and bend at the waist until your forehead touches the ground. Lift back into the starting position to complete one rep.'||
                                     'Step 4: For an even harder exercise, lower by bending your knees instead of your hips. You’ll have to catch yourself with your hands to prevent injury. Rebound with a short push off the ground to get back into the starting position.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('2', 'Dead Stop to Superman', 'Step 1: Start in a pushup/plank position. Squeeze your glutes and core to keep your spine straight.'||
                                       'Step 2: Bend your elbows to lower your chest down to the ground. This is the stop part of the exercise.'||
                                       'Step 3: Lift your hands off the ground, then extend your arms straight out in front of you, squeezing your back at the top of the movement.'||
                                       'Step 4: Retract your arms back to the starting position, then push yourself back up.', '5', '30', '3', '2');


INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Lunges', 'Pretend you''re walking forward in a silly way but then step back', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Elevated Shrimp Squat', 'Step 1: Stand up straight with your feet hip-width apart, bend your left knee to the back and grab your left foot with your right hand.'||
                                       'Step 2: Start bending your right knee and slowly lower your hips back.'||
                                       'Step 3: Push through the right heel to return to the starting position.'||
                                       'Step 4: Switch legs and repeat.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Back Leg Elevated Lunge', 'Step 1:Place your right foot on a bench or step, keeping your toes pointed, your foot flexed, and pressure penetrating the ball of your left foot [and the top of your right foot].'||
                                        'Step 2: Once in position, descend under control until your right knee just about touches the floor and drive back up through your left leg to the starting position.'||
                                        'Step 3: Make sure your back knee doesn’t collapse toward your body, and that your forward knee doesn’t slide past your toes.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Side Lunge Squat', 'Step 1: Take a wide step with your left leg to the side of you. Both your toes should be pointed in the same direction and your feet should be flat on the floor.'||
                                  'Step 2:Bend your left knee as you step outward and keep your hips back. It should feel like you are trying to sit just one side of your lower body in a chair.'||
                                  'Step 3:Release the position by pushing off your left foot to return to the starting position.'||
                                  'Step 4:Perform one set of side lunges on your left leg, then switch to your right leg.'||
                                  'Step 5:Repeat for additional sets.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Leg Romanian Deadlift', 'Step 1: Stand with your feet shoulder-width apart and knees slightly bent and raise one leg off the floor. Flex the knee on your standing/support leg'||
                                       'Step 2: Without changing the bend in your knee, keep your back naturally arched, bend (hinge) at your hips, and lower your torso until it’s almost'||
                                       'Step 3: Briefly pause at the bottom, then squeeze you glutes, thrust your hips forward, and raise your torso back to the starting position.'||
                                       'Step 4: Repeat until you complete the prescribed number of repetitions (10-15 reps with light or no weight and 6-8 with moderate to heavy weight….shoot for 3 sets on each leg).', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Sissy Squat', 'Step 1:Lower your body into a squat by bending your knees and leaning your body backwards.'||
                             'Step 2:Squat as low as you can without losing your balance.'||
                             'Step 3:Hold the position for 3 seconds.'||
                             'Step 4:Push yourself back up to the starting position.'||
                             'Step 5:Repeat.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Box Jump',  'Step 1:Stand facing a sturdy box or step with your feet hip-width apart.'||
                          'Step 2:Bend your knees into a quarter-squat and bring both arms behind you.'||
                          'Step 3:Swing your arms forward and quickly drive through your legs to jump onto the middle of the box or step.'||
                          'Step 4:Land softly with your knees bent.'||
                          'Step 5:Straighten your legs before stepping down from the box. Repeat.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('3', 'Depth Jump', 'Step 1: Stand on a 12-inch platform with toes on the edge.'||
                            'Step 2: Next, step off the platform and land on the balls of both feet simultaneously.'||
                            'Step 3: Immediately upon touching the ground, tighten your leg muscles and jump as high as you can off the ground. This completes one rep.', '5', '30', '3', '2');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Arm Circles', 'Step 1: Stand tall with your arms straight out to your sides and your muscles contracted down the length of your arm.'||
                             'Step 2: Slowly make circles with your arms by rotating them around your shoulders while keeping them straight and your elbows locked with tension.'||
                             'Step 3: Perform 3 sets of 10–20 repetitions in both directions. You can perform sets of large or small diameter circles to slightly change the effort required.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Arm Front Raises', 'Step 1:Stand tall with your arms out to the front, locked out straight with your thumbs toward the ceiling.'||
                                  'Step 2:Raise your arms overhead while keeping them straight and locked out until they point straight up overhead, with your upper arms blocking your ears when viewed from the side.'||
                                  'Step 3:Slowly lower your arms to the starting position.'||
                                  'Step 4:Perform 3 sets of 10–20 repetitions.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Arm lateral raises', 'Step 1:Stand with your arms at your sides and your palms facing inward toward your hips.'||
                                    'Step 2: Keep your arms straight and raise them to the side until your body makes a “T” when viewed from the front.'||
                                   'Step 3: Slowly lower to the starting position.'||
                                    'Step 4: Repeat for 10–20 repetitions.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Wall angels', 'Step 1: Stand with your back against a wall with your knees bent and your feet roughly 1–2 feet (about 0.5 meters) away from the wall. Your head, upper back, and tailbone should be in contact with the wall.'||
                             'Step 2: Bend your elbows to 90 degrees and raise your arms until your upper arms are parallel to the floor, as if you’re putting your hands up.'||
                             'Step 3: Extend your arms overhead until they’re straight. Aim to keep your arms, head, upper back, and tailbone in contact with the wall.'||
                             'Step 4: Return to the starting position. Repeat for 3 sets 10–12 repetitions.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Downward Dog To Plank', 'Step 1: Begin in a pushup plank position with your hands under your shoulders and your arms straight. You can start with your knees on the ground if the pushup plank position is too challenging.'||
                                       'Step 2: Raise your hips and press backward with your arms to arrive into the Downward Dog Pose. If you started from your knees, you will raise your knees off of the ground once you have pushed back enough to do so.'||
                                       'Step 3: Stabilize briefly in the Downward Dog Pose before returning to the starting position.'||
                                       'Step 4: Repeat for 3 sets of 10–12 repetitions.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Plank Tap', 'Step 1: Begin in a pushup plank position with your hands under your shoulders and your arms straight. Keep your spine neutral. To make the exercise more challenging, keep your feet together. To make it easier, widen your feet.'||
                           'Step 2: Bring your left hand up to your right shoulder and tap it before returning your hand to the floor.'||
                           'Step 3:Repeat with your right hand and left shoulder.'||
                           'Step 4:Perform 3 sets of 10–12 repetitions on each side.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Pushup', 'Step 1:Begin in a pushup position with your hands under your shoulders, spine neutral, and legs straight. If needed, keep your knees on the ground to reduce the difficulty level.'||
                        'Step 2: Lower your entire body in unison toward the floor by bending at the elbow. Keep your elbows close to your sides or at about a 45–degree angle. Lower your chest until your upper arm is parallel to the floor.'||
                        'Step 3: Push through the floor to drive back to the top position, maintaining control the entire time.'||
                        'Step 4: Repeat for 3 sets of 10–12 repetitions. If the sets become too difficult, you can revert to the knees-down variation.', '5', '30', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('4', 'Triceps Dip', 'Step 1:Place your hands shoulder-width apart on the chair you’re propping yourself upon.'||
                             'Step 1:Shift your pelvis and bottom forward so there’s a gap of 3–6 inches (8–15 cm) between your back and the chair, giving you clearance as you dip down.'||
                             'Step 1:Bend your legs to a 90–degree angle with your feet planted firmly on the ground, or extend them out in front of you (but don’t lock your knees).'||
                            'Step 1: Slowly lower your body straight down and then push back up, focusing on engaging your triceps.'||
                            'Step 1: Complete 3 sets of 10–12 reps.', '5', '30', '3', '2');

INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Planks Hold', 'Prop yourself up parallel to the floor and hold til it burns', '5', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Situps', 'Lay on your back and lift your torso!', '5', '40', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Jackknife Sit-Up', 'Step 1:Lie flat on the floor with your legs straight and arms behind your head. Your heels, legs, buttocks, upper back, head, and arms should contact the floor.'||
                                  'Step 2:Take a breath and engage your abs.'||
                                  'Step 3:Simultaneously lift your arms and legs a few inches off the floor.'||
                                  'Step 4:Once you’re in that position, take another breath and lift your arms and legs toward one another. You should raise your legs to a 45-degree angle and have your arms almost parallel with your hands touching your shins. Exhale once you touch your shins.'||
                                  'Step 5:Extend your body back to the starting position without resting your hands or feet on the floor.'||
                                  'Step 6:Take a breath and repeat the motion.', '5', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Oblique Crunch', 'Step 1: Lie on your left side on an exercise mat with your knees slightly bent.'||
                                'Step 2: Place your left hand on your abdominal and your right hand against the right side of your head.'||
                                'Step 3: While breathing out, raise your shoulders off the ground, crunching your obliques by bringing your elbow toward your hip.'||
                                'Step 4: Hold in the crunch position for a few counts and then slowly lower yourself back down to the exercise mat while breathing in.'||
                                'Step 5: Repeat for as many repetitions as are comfortable.', '5', '40', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Planks', 'Prop yourself up parallel to the floor and hold til it burns', '5', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Dead Bug',  'Step 1:Lie faceup with your arms extended toward the ceiling and your legs in a tabletop position (knees bent 90 degrees and stacked over your hips). This is the starting position.'||
                          'Step 2:Slowly extend your left leg out straight, while simultaneously dropping your right arm overhead. Keep both a few inches from the ground. Squeeze your butt and keep your core engaged the entire time, lower back pressed into the floor.'||
                          'Step 3:Bring your arm and leg back to the starting position.'||
                          'Step 4:Repeat on the other side, extending your right leg and your left arm. That’s 1 rep.'||
                          'Step 5:Continue for a set amount of reps.', '5', '40', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Air Bicycle', 'Step 1: Lie on your back on an exercise mat, keeping your lower back pressed against the mat. Gently support your neck by bracing your hands against the back of your head.'||
                             'Step 2: Lift your upper body off the mat while bringing your knees to up above your torso and keeping your legs parallel to the floor.'||
                             'Step 3: Extend your right leg straight out without letting it touch the floor. Keep your left knee bent and your left leg parallel to the floor. Using your abdominals, crunch upwards and sideways, extending your right elbow to your left knee.'||
                             'Step 4: Alternating elbows and knees, now extend your left leg while bringing your right knee toward your torso (similar to riding a bicycle), and crunch sideways so that your left elbow extends toward your right knee.'||
                             'Step 5: Continue to repeat, alternating knees and elbows.', '5', '0', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('5', 'Lying Leg Raise', 'Step 1: Lay down with your back flat on the floor, feet straight out and together and your hands on your side.'||
                                 'Step 2: While keep your legs as straight as you can lift your feet up in the air between 6-12 inches.'||
                                 'Step 3: You can either hold for designated period of time or you can raise them up and then lower them right back down. This completes one repetition.', '5', '40', '3', '2');


INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Deadlifts', 'Hips hinge backward to lower down and pick up a weighted barbell or Kettle bell from the floor', '5', '45', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Single Arm Dumbbell Bench Press ', 'Lie on a flat bench and hold a dumbbell in one hand, extending your arm until its straight and the weight is in line with your shoulder. Slowly lower to your chest and repeat', '5', '35', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Squat to Curtsy Lunge', 'Step 1:Start with your feet hip-width apart, core engaged, and hands held in a prayer or fist at chest height.'||
                                       'Step 2:Do a squat by hinging at the hips, sending your hips back, and bending both knees until your thighs are parallel to the floor.'||
                                       'Step 3:As you stand, bring your right foot behind your left leg, placing it down diagonally and behind you.'||
                                       'Step 4:Bend both knees and sink into a curtsy squat, keeping your hips tucked and core engaged.'||
                                       'Step 5:Return to your starting position and do another squat, then repeat the curtsy lunge on the same side.'||
                                       'Step 6:Do all of the reps on one side, then repeat on the other.', '5', '45', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Glute Bridge', 'Step 1:Lie faceup with your knees bent, feet flat on the floor, and heels a few inches away from your butt so that your fingertips graze your heels when arms are at your sides.'||
                              'Step 2:Squeeze your glutes and abs and push through your heels to lift your hips off the floor until your body forms a straight line from your shoulders to your knees.'||
                              'Step 3:Pause and squeeze your glutes at the top, then slowly lower your hips to return to the starting position.', '5', '35', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Tuck-Up', 'Step 1: Lie faceup with your legs extended and arms overhead so that all of your limbs are resting on the floor.'||
                         'Step 2: Engage your core and lift both arms and legs a few inches off the floor to come into a hollow hold position.'||
                         'Step 3: Now crunch up, sitting all the way up and simultaneously bringing your knees to your chest, and wrap your hands lightly around your shins.'||
                         'Step 4: Keep your core tight to balance on your sit bones—do not grip your shins or hug your knees in order to achieve balance.'||
                         'Step 5: Lower to return to hollow hold position and repeat.', '5', '45', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Russian Twist', 'Step 1: Sit tall with knees bent and feet flexed, so heels rest on the floor. Keep your back as flat as possible, chest up, and core engaged.'||
                               'Step 2: If you’re using a weight, hold one weight with both hands close to your chest. If you’re not using a weight, hold hands in prayer at chest height.'||
                               'Step 2: Rotate your torso and arms to the right, bringing hands down by your side. (Your hands do not have to touch the floor.) Keep your legs and hips as still as possible, and do not arch or round your spine as you twist.'||
                               'Step 3: Repeat on the other side. Move as quickly as possible, rotating side to side, while maintaining good form.'||
                               'Step 4: Make it harder: Lift feet off the floor, so shins are parallel to the floor and you balance on your sit bones throughout the exercise.', '5', '35', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Forearm Plank Hold', 'Step 1: Place your forearms on the floor, elbows directly underneath your shoulders, hands facing forward so that your arms are parallel. '||
                                   'Step 2: Extend your legs behind you, feet hip-width apart. Tuck your tailbone and engage your core, butt, and quads.'||
                                    'Step 3: Hold.'||
                                    'Step 4: Make it easier: If it is not difficult to hold the plank for the full time period, gently allow your knees to come to the floor, take a few deep breaths, then lift them again. '||
                                    'Resist the urge to simply collapse your chest to the floor. Work to bring knees to the floor with control, then lift them again.', '5', '45', '3', '2');
INSERT INTO exercise (body_group_id, exercise_name, description, expected_time, suggested_weight, number_of_reps, user_id)
VALUES ('6', 'Shoulder bridge',  'Step 1:Lie faceup with your knees bent and your feet hip-width apart.'||
                                 'Step 2:Place your arms at your sides and lift your spine and hips. Only your head, feet, arms, and shoulders should be on the floor.'||
                                 'Step 3:Lift one leg, keeping your core tight.'||
                                 'Step 4:Slowly bring your leg back down, then lift back up.'||
                                 'Step 5:Try to do 10 reps per leg, then lower your spine back onto the floor.', '5', '35', '3', '2');

COMMIT TRANSACTION;

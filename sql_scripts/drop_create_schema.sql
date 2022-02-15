DROP TABLE IF EXISTS gyms;
DROP TABLE IF EXISTS season_pass;
DROP TABLE IF EXISTS trainings;

CREATE TABLE gyms
(
    gym_id SERIAL PRIMARY KEY,
    address VARCHAR(255),
    gym_num INTEGER,
    open_time varchar(15)
);

CREATE TABLE season_pass
(
    user_id SERIAL PRIMARY KEY,
    gym_id BIGINT REFERENCES gyms,
    full_name VARCHAR(255),
    duration_m INTEGER
);

CREATE TABLE trainings
(
    train_id SERIAL PRIMARY KEY,
    gym_id BIGINT REFERENCES gyms,
    training_name VARCHAR(255),
    trainer_name VARCHAR(255),
    minutes INTEGER
);


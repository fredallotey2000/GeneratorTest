CREATE TABLE plants(
  sequence_number BIGSERIAL PRIMARY KEY,
  year VARCHAR(4) NOT NULL,
  plant_location_code CHAR(2) NOT NULL,
  plant_name VARCHAR(100) NOT NULL,
generator_id VARCHAR(6) NOT NULL,
generator_status CHAR(2) NOT NULL,
generator_annual_net_generation DECIMAL
);

CREATE TABLE users(
  user_id BIGSERIAL PRIMARY KEY,
  username VARCHAR(16) NOT NULL UNIQUE,
  password VARCHAR(150) NOT NULL ,
  role VARCHAR(16) NOT NULL,
account_non_expired BOOLEAN NOT NULL,
account_non_locked BOOLEAN NOT NULL,
credentials_non_expired BOOLEAN NOT NULL,
enabled BOOLEAN NOT NULL
);


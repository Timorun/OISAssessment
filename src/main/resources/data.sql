-- Drop all entries to prevent duplicate key violations and start fresh
DELETE FROM admin;
DELETE FROM participant;


INSERT INTO admin (username, password) VALUES
                                           ('admin1', '$2a$10$kUFoKkvBLyTVxO0HV1LU3.jljWWDBoyTb99LTeEe/3Z6m28v3.9B6'),
                                           ('admin2', '$2a$12$ZnvpQUCGtqJKxYHzXljCq.Tv8mq30diCFyA0JqPL3/PYkcdTgraRq'),
                                           ('admin3', '$2a$12$iGouvPQxC0HARTbzemnJ5unlcnhkxvSQHEN85RXPG9lHXjJBHvrdO');

INSERT INTO participant (name, email, phone_number, address) VALUES
                                                                 ('John Doe', 'john.doe@example.com', '1234567890', '123 Main St'),
                                                                 ('Jane Smith', 'jane.smith@example.com', '9876543210', '456 Elm St'),
                                                                 ('Alice Johnson', 'alice.johnson@example.com', '5551112222', '789 Oak St'),
                                                                 ('Bob Williams', 'bob.williams@example.com', '7778889999', '101 Pine St'),
                                                                 ('Eve Brown', 'eve.brown@example.com', '4443332222', '202 Maple St'),
                                                                 ('Michael Lee', 'michael.lee@example.com', '3334445555', '303 Cedar St'),
                                                                 ('Emily Davis', 'emily.davis@example.com', '6667778888', '404 Walnut St'),
                                                                 ('David Garcia', 'david.garcia@example.com', '2225558888', '505 Birch St'),
                                                                 ('Sarah Rodriguez', 'sarah.rodriguez@example.com', '9992225555', '606 Willow St'),
                                                                 ('William Martinez', 'william.martinez@example.com', '1116669999', '707 Spruce St');;

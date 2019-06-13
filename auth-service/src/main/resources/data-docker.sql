INSERT INTO oauth_client_details
(client_id, client_secret, scope, authorized_grant_types,
 web_server_redirect_uri, authorities, access_token_validity,
 refresh_token_validity, additional_information, autoapprove)
VALUES ('fooClientIdPassword', '$2a$10$mc5IIM8aD/vqU1uH4vUxqOHSQZ2stveKJf88/1ZdQ0QpdrPnKXzG2', 'foo,read,write',
        'password,authorization_code,refresh_token',
        'http://192.168.99.100:9999/client/login', null, 36000, 36000, null, true);


INSERT INTO user_details (email, `password`)
VALUES ('aram.mkrtchyan.87@gmail.com', '$2a$10$XAEvZtfywgdak9CCyZWtReSspBF9mVl6ezFLXMACpHCA/MhCF0vkW');

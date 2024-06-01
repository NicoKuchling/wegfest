CREATE TABLE QUESTION (
    ID UUID PRIMARY KEY,
    QUESTION VARCHAR(256) NOT NULL
);

CREATE TABLE QUESTION_ANSWER (
    QUESTION_ID UUID NOT NULL,
    ANSWER VARCHAR(256) NOT NULL,
    CONSTRAINT FK_QUESTION_ANSWER_QUESTION_ID FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION(ID)
);

-- Question 1 --
INSERT INTO QUESTION
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Wie verständlich waren die Erklärungen des Tutorials?');
INSERT INTO QUESTION_ANSWER
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Sehr verständlich');
INSERT INTO QUESTION_ANSWER
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Verständlich');
INSERT INTO QUESTION_ANSWER
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Teilweise verständlich, teilweise unverständlich');
INSERT INTO QUESTION_ANSWER
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Unverständlich');
INSERT INTO QUESTION_ANSWER
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Sehr unverständlich');

-- Question 2 --
INSERT INTO QUESTION
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Wie hast du das Überqueren der Straße empfunden?');
INSERT INTO QUESTION_ANSWER
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Sehr leicht');
INSERT INTO QUESTION_ANSWER
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Leicht');
INSERT INTO QUESTION_ANSWER
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Teilweise leicht, teilweise schwer');
INSERT INTO QUESTION_ANSWER
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Schwer');
INSERT INTO QUESTION_ANSWER
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Sehr schwer');

-- Question 3 --
INSERT INTO QUESTION
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Wie hast du dich beim Überqueren der Straße gefühlt?');
INSERT INTO QUESTION_ANSWER
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Sehr sicher');
INSERT INTO QUESTION_ANSWER
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Sicher');
INSERT INTO QUESTION_ANSWER
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Teilweise sicher, teilweise unsicher');
INSERT INTO QUESTION_ANSWER
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Unsicher');
INSERT INTO QUESTION_ANSWER
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Sehr unsicher');

-- Question 4 --
INSERT INTO QUESTION
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Wie findest du die Darstellung des Szenarios?');
INSERT INTO QUESTION_ANSWER
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Sehr Realistisch');
INSERT INTO QUESTION_ANSWER
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Realistisch');
INSERT INTO QUESTION_ANSWER
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Teilweise realistisch, teilweise unrealistisch');
INSERT INTO QUESTION_ANSWER
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Unrealistisch');
INSERT INTO QUESTION_ANSWER
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Sehr unrealistisch');

-- Question 5 --
INSERT INTO QUESTION
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Wie findest du die Informationsgabe in der Anwendung?');
INSERT INTO QUESTION_ANSWER
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Sehr verständlich');
INSERT INTO QUESTION_ANSWER
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Verständlich');
INSERT INTO QUESTION_ANSWER
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Unverständlich');
INSERT INTO QUESTION_ANSWER
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Sehr unverständlich');

-- Question 6 --
INSERT INTO QUESTION
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Wie empfindest du die gesamte Nutzungsdauer?');
INSERT INTO QUESTION_ANSWER
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Angemessen');
INSERT INTO QUESTION_ANSWER
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Zu lang');
INSERT INTO QUESTION_ANSWER
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Zu kurz');

-- Question 7 --
INSERT INTO QUESTION
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Traten bei Anwendungsnutzung Symptome auf?');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Übelkeit');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Schwindel');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Starkes Schwitzen');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Kopfschmerzen');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Allgemeines Unwohlsein');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Gleichgewichtsprobleme');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Sonstiges');
INSERT INTO QUESTION_ANSWER
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Keine Symptome');
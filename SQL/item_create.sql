CREATE TABLE ITEM (
    ID UUID NOT NULL,
    QUESTION VARCHAR(256) NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    CONSTRAINT PK_ITEM PRIMARY KEY (ID)
);

CREATE TABLE ITEM_RESPONSE (
    ITEM_ID UUID NOT NULL,
    RESPONSE VARCHAR(256) NOT NULL,
    IS_DELETED BOOLEAN NOT NULL,
    CONSTRAINT PK_ITEM_RESPONSE PRIMARY KEY (ITEM_ID, RESPONSE),
    CONSTRAINT FK_ITEM_RESPONSE_ITEM_ID FOREIGN KEY (ITEM_ID) REFERENCES ITEM(ID)
);

-- ITEM 1 --
INSERT INTO ITEM
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Wie verständlich waren die Erklärungen des Tutorials?');
INSERT INTO ITEM_RESPONSE
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Sehr verständlich');
INSERT INTO ITEM_RESPONSE
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Verständlich');
INSERT INTO ITEM_RESPONSE
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Teilweise verständlich, teilweise unverständlich');
INSERT INTO ITEM_RESPONSE
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Unverständlich');
INSERT INTO ITEM_RESPONSE
VALUES ('485cf8b2-0ceb-40fe-a0d6-c4dbc691cf53', 'Sehr unverständlich');

-- ITEM 2 --
INSERT INTO ITEM
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Wie hast du das Überqueren der Straße empfunden?');
INSERT INTO ITEM_RESPONSE
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Sehr leicht');
INSERT INTO ITEM_RESPONSE
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Leicht');
INSERT INTO ITEM_RESPONSE
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Teilweise leicht, teilweise schwer');
INSERT INTO ITEM_RESPONSE
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Schwer');
INSERT INTO ITEM_RESPONSE
VALUES ('c058bbec-84ab-4bdb-833a-cf09ed1cb3d0', 'Sehr schwer');

-- ITEM 3 --
INSERT INTO ITEM
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Wie hast du dich beim Überqueren der Straße gefühlt?');
INSERT INTO ITEM_RESPONSE
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Sehr sicher');
INSERT INTO ITEM_RESPONSE
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Sicher');
INSERT INTO ITEM_RESPONSE
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Teilweise sicher, teilweise unsicher');
INSERT INTO ITEM_RESPONSE
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Unsicher');
INSERT INTO ITEM_RESPONSE
VALUES ('6a4b8959-1fad-4b50-ab28-dd9d4d322468', 'Sehr unsicher');

-- ITEM 4 --
INSERT INTO ITEM
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Wie findest du die Darstellung des Szenarios?');
INSERT INTO ITEM_RESPONSE
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Sehr Realistisch');
INSERT INTO ITEM_RESPONSE
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Realistisch');
INSERT INTO ITEM_RESPONSE
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Teilweise realistisch, teilweise unrealistisch');
INSERT INTO ITEM_RESPONSE
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Unrealistisch');
INSERT INTO ITEM_RESPONSE
VALUES ('16718a5f-bf5e-417b-b329-e74dd83e12b9', 'Sehr unrealistisch');

-- ITEM 5 --
INSERT INTO ITEM
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Wie findest du die Informationsgabe in der Anwendung?');
INSERT INTO ITEM_RESPONSE
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Sehr verständlich');
INSERT INTO ITEM_RESPONSE
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Verständlich');
INSERT INTO ITEM_RESPONSE
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Unverständlich');
INSERT INTO ITEM_RESPONSE
VALUES ('9eb94266-918c-47e3-b970-c8c9b4029d93', 'Sehr unverständlich');

-- ITEM 6 --
INSERT INTO ITEM
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Wie empfindest du die gesamte Nutzungsdauer?');
INSERT INTO ITEM_RESPONSE
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Angemessen');
INSERT INTO ITEM_RESPONSE
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Zu lang');
INSERT INTO ITEM_RESPONSE
VALUES ('be8c16d8-3fb1-46a9-acdc-65f616991fcc', 'Zu kurz');

-- ITEM 7 --
INSERT INTO ITEM
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Traten bei Anwendungsnutzung Symptome auf?');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Übelkeit');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Schwindel');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Starkes Schwitzen');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Kopfschmerzen');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Allgemeines Unwohlsein');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Gleichgewichtsprobleme');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Sonstiges');
INSERT INTO ITEM_RESPONSE
VALUES ('d6b3d3d0-76f0-4438-83a6-d895affff412', 'Keine Symptome');
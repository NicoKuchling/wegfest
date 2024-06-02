CREATE TABLE TRAFFIC_SCENE (
    ID UUID PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    DIFFICULTY VARCHAR(255) NOT NULL,
    QUESTIONNAIRE_ID UUID,
    FOREIGN KEY (QUESTIONNAIRE_ID) REFERENCES QUESTIONNAIRE(ID)
);

-- Traffic scene 1 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('47992ca4-0b01-46ac-9e3f-2bf1bc451de5', 'Einspurig ohne Hilfsmittel', 'Überquerung einer einspurigen Straße ohne Hilfsmittel', 'easy');

-- Traffic scene 2 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('f78c4558-8cf8-4e65-978a-44133ecfaeea', 'Einspurig Verkehrsinsel', 'Überquerung einer einspurigen Straße mit einer Verkehrsinsel in der Mitte', 'easy');

-- Traffic scene 3 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('d2a4d8a7-d215-4358-9bd2-2094fa782916', 'Einspurig Zebrastreifen', 'Überquerung einer einspurigen Straße über einen Zebrastreifen', 'easy');

-- Traffic scene 4 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('9f947dca-2b78-43e5-b6a1-74503cefdeb2', 'Einspurig Ampel', 'Überquerung einer einspurigen Straße mit Hilfe einer Ampel', 'easy');

-- Traffic scene 5 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('592cea80-e494-4123-9eb2-86db5c0557a8', 'Zweispurig ohne Hilfsmittel', 'Überquerung einer zweispurigen Straße ohne Hilfsmittel', 'easy');

-- Traffic scene 6 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('4eb78c38-55aa-4dfc-857c-d9094d4f468a', 'Zweispurig Verkehrsinsel', 'Überquerung einer zweispurigen Straße mit einer Verkehrsinsel in der Mitte', 'easy');

-- Traffic scene 7 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('b1990157-d266-4699-a1f2-866c4624316a', 'Zweispurig Zebrastreifen', 'Überquerung einer zweispurigen Straße über einen Zebrastreifen', 'easy');

-- Traffic scene 8 --
INSERT INTO TRAFFIC_SCENE (ID, NAME, DESCRIPTION, DIFFICULTY)
VALUES ('a5331cd9-f51f-487d-aae5-58b7b85430f6', 'Zweispurig Ampel', 'Überquerung einer zweispurigen Straße mit Hilfe einer Ampel', 'easy');
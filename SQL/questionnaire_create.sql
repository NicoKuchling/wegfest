CREATE TABLE QUESTIONNAIRE (
    ID UUID PRIMARY KEY,
    IS_TEMPLATE BOOLEAN NOT NULL,
    PERSON_ID UUID,
    FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID)
);

CREATE TABLE QUESTIONNAIRE_QUESTION (
    QUESTIONNAIRE_ID UUID NOT NULL,
    QUESTION_ID UUID NOT NULL,
    PRIMARY KEY (QUESTIONNAIRE_ID, QUESTION_ID),
    FOREIGN KEY (QUESTIONNAIRE_ID) REFERENCES QUESTIONNAIRE(ID),
    FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION(ID)
);

CREATE TABLE ANSWERED_QUESTION (
   QUESTIONNAIRE_ID UUID NOT NULL,
   QUESTION_ID UUID NOT NULL,
   ANSWER VARCHAR(255),
   PRIMARY KEY (QUESTIONNAIRE_ID, QUESTION_ID),
   FOREIGN KEY (QUESTIONNAIRE_ID) REFERENCES QUESTIONNAIRE(ID),
   FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION(ID)
);
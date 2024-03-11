CREATE TABLE IF NOT EXISTS VET_CALL(ID INT PRIMARY KEY AUTO_INCREMENT,
                  FULL_NAME VARCHAR(255),
                  EMAIL VARCHAR(255),
                  SERVICE VARCHAR(255),
                  BRANCH VARCHAR(255),
                  SCREEN VARCHAR(255),
                  CALL_REASON VARCHAR(255),
                  CALL_CLAIM_DESCRIPTION VARCHAR(255),
                  CLAIM_ID VARCHAR(255),
                  CLAIM_TYPE VARCHAR(255),
                  CLAIM_PHASE VARCHAR(255));
INSERT INTO vet_call (full_name, email, service, branch, claim_id, claim_type, claim_phase, screen, call_reason, call_claim_description)
           VALUES ('John A. Doe', 'johndoe@gmail.com', 'IDME', 'Air Force', '1111', 'claim', 'props1', 'screen', 'Check Claim/Appeal Status', 'Call for compensation updated on 11/22/2023');
INSERT INTO vet_call (full_name, email, service, branch, claim_id, claim_type, claim_phase, screen, call_reason, call_claim_description)
           VALUES ('Jane E. Doe', 'janedoe@gmail.com', 'IDME', 'Navy', '2222', 'claim', 'props2', 'screen', 'I have a reason', 'I have a description');
COMMIT;

CREATE SEQUENCE SEQ_CLIENTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE TB_CLIENTE(
    CLIENTE_ID                  INTEGER DEFAULT SEQ_CLIENTE.NEXTVAL     NOT NULL,
    NOME                        VARCHAR2(50)                            NOT NULL,
    CPF                         VARCHAR2(11)                            NOT NULL,
    DATA_NASCIMENTO             DATE                                    NOT NULL,
    EMAIL                       VARCHAR2(50)                            NOT NULL,
    TELEFONE                    VARCHAR2(11)                            NOT NULL,
    DATA_CADASTRO               DATE                                    NOT NULL,
    STATUS_CLIENTE              VARCHAR2(10)                            NOT NULL,
    TIPO_CLIENTE                VARCHAR2(50)                            NOT NULL,
)
-- Table: public.task

-- DROP TABLE IF EXISTS public.task;

CREATE TABLE IF NOT EXISTS public.task
(
    taskid integer NOT NULL DEFAULT nextval('task_taskid_seq'::regclass),
    taskname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    deadline date NOT NULL,
    priority integer NOT NULL,
    category character varying(255) COLLATE pg_catalog."default" NOT NULL,
    status taskstatus NOT NULL,
    CONSTRAINT task_pkey PRIMARY KEY (taskid)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.task
    OWNER to postgres;

CREATE TYPE taskStatus as ENUM('TODO', 'DOING', 'DONE');

CREATE TABLE task (
                      taskID serial PRIMARY KEY,
                      taskName VARCHAR(255)  NOT NULL,
                      description TEXT  NOT NULL,
                      deadline DATE  NOT NULL,
                      priority INT  NOT NULL,
                      category VARCHAR(255)  NOT NULL,
                      status taskStatus NOT NULL
);
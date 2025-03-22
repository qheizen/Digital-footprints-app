CREATE TABLE IF NOT EXISTS public."User"
(
    "completed_courses" double precision[],
    "current_skill_level" double precision[],
    userid uuid NOT NULL,
    "name" text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "user_pkey" PRIMARY KEY (userid)
)
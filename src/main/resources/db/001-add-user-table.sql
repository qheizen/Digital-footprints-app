CREATE TABLE IF NOT EXISTS public."User"
(
    "completedCourses" double precision[],
    "currentSkillLevel" double precision[],
    userid uuid NOT NULL,
    "Username" text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "User_pkey" PRIMARY KEY (userid)
)
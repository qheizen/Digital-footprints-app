CREATE TABLE IF NOT EXISTS public."Course"
(
    "courseType" integer,
    lessons text[] COLLATE pg_catalog."default",
    prerequisites text[] COLLATE pg_catalog."default",
    "targetSkillLevel" double precision,
    "courseId" uuid NOT NULL,
    CONSTRAINT "Course_pkey" PRIMARY KEY ("courseId")
)

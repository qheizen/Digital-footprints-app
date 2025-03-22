CREATE TABLE IF NOT EXISTS public."Course"
(
    "courseType" integer,
    lessons text[] COLLATE pg_catalog."default",
    prerequisites text[] COLLATE pg_catalog."default",
    "target_skill_level" double precision,
    "course_id" uuid NOT NULL,
    CONSTRAINT "course_pkey" PRIMARY KEY ("courseId")
)

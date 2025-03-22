CREATE TABLE IF NOT EXISTS public."Course_ABSTRACT"
(
    "course_id" uuid NOT NULL,
    description text COLLATE pg_catalog."default",
    title integer NOT NULL,
    CONSTRAINT "course_abstract_pkey" PRIMARY KEY ("course_id")
)

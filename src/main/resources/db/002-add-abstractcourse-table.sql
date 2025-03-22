CREATE TABLE IF NOT EXISTS public."Course_ABSTRAX"
(
    "courseId" uuid NOT NULL,
    description text COLLATE pg_catalog."default",
    title integer NOT NULL,
    CONSTRAINT "Course_ABSTRAX_pkey" PRIMARY KEY ("courseId")
)

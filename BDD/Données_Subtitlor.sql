--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12.0

-- Started on 2019-12-05 13:44:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2836 (class 0 OID 24579)
-- Dependencies: 203
-- Data for Name: fichier; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fichier (id, nom) VALUES (1, 'password_presentation.srt');
INSERT INTO public.fichier (id, nom) VALUES (2, 'password_presentation.srt');
INSERT INTO public.fichier (id, nom) VALUES (3, 'password_presentation.srt');
INSERT INTO public.fichier (id, nom) VALUES (4, 'password_presentation.srt');
INSERT INTO public.fichier (id, nom) VALUES (5, 'password_presentation.srt');
INSERT INTO public.fichier (id, nom) VALUES (6, 'password_presentation.srt');
INSERT INTO public.fichier (id, nom) VALUES (7, 'password_presentation.srt');
INSERT INTO public.fichier (id, nom) VALUES (8, 'password_presentation.srt');


--
-- TOC entry 2838 (class 0 OID 24590)
-- Dependencies: 205
-- Data for Name: language; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.language (id, langue) VALUES (1, 'Français');
INSERT INTO public.language (id, langue) VALUES (2, 'English');
INSERT INTO public.language (id, langue) VALUES (3, 'Deutsh');
INSERT INTO public.language (id, langue) VALUES (4, 'Spanish');


--
-- TOC entry 2839 (class 0 OID 24599)
-- Dependencies: 206
-- Data for Name: traduction; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 202
-- Name: fichier_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fichier_id_seq', 7, true);


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 204
-- Name: language_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.language_id_seq', 4, true);


-- Completed on 2019-12-05 13:44:10

--
-- PostgreSQL database dump complete
--


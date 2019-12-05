--
-- PostgreSQL database dump
--

-- Dumped from database version 12.0
-- Dumped by pg_dump version 12.0

-- Started on 2019-12-05 13:43:39

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 24579)
-- Name: fichier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fichier (
    id integer NOT NULL,
    nom character varying NOT NULL
);


ALTER TABLE public.fichier OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24577)
-- Name: fichier_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fichier_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.fichier_id_seq OWNER TO postgres;

--
-- TOC entry 2840 (class 0 OID 0)
-- Dependencies: 202
-- Name: fichier_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fichier_id_seq OWNED BY public.fichier.id;


--
-- TOC entry 205 (class 1259 OID 24590)
-- Name: language; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.language (
    id integer NOT NULL,
    langue character varying NOT NULL
);


ALTER TABLE public.language OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24588)
-- Name: language_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.language_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.language_id_seq OWNER TO postgres;

--
-- TOC entry 2841 (class 0 OID 0)
-- Dependencies: 204
-- Name: language_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.language_id_seq OWNED BY public.language.id;


--
-- TOC entry 206 (class 1259 OID 24599)
-- Name: traduction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.traduction (
    id_fichier integer NOT NULL,
    numerotrad integer NOT NULL,
    temps character varying NOT NULL,
    id_langue_source integer NOT NULL,
    ligne1_source character varying NOT NULL,
    ligne2_source character varying NOT NULL,
    id_langue_trad integer NOT NULL,
    ligne1_trad character varying NOT NULL,
    ligne2_trad character varying NOT NULL
);


ALTER TABLE public.traduction OWNER TO postgres;

--
-- TOC entry 2700 (class 2604 OID 24582)
-- Name: fichier id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fichier ALTER COLUMN id SET DEFAULT nextval('public.fichier_id_seq'::regclass);


--
-- TOC entry 2701 (class 2604 OID 24593)
-- Name: language id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.language ALTER COLUMN id SET DEFAULT nextval('public.language_id_seq'::regclass);


--
-- TOC entry 2703 (class 2606 OID 24587)
-- Name: fichier fichier_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fichier
    ADD CONSTRAINT fichier_pk PRIMARY KEY (id);


--
-- TOC entry 2705 (class 2606 OID 24598)
-- Name: language language_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.language
    ADD CONSTRAINT language_pk PRIMARY KEY (id);


--
-- TOC entry 2706 (class 2606 OID 24605)
-- Name: traduction fichier_traduction_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traduction
    ADD CONSTRAINT fichier_traduction_fk FOREIGN KEY (id_fichier) REFERENCES public.fichier(id);


--
-- TOC entry 2707 (class 2606 OID 24610)
-- Name: traduction language_traduction_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traduction
    ADD CONSTRAINT language_traduction_fk FOREIGN KEY (id_langue_source) REFERENCES public.language(id);


--
-- TOC entry 2708 (class 2606 OID 24615)
-- Name: traduction language_traduction_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.traduction
    ADD CONSTRAINT language_traduction_fk1 FOREIGN KEY (id_langue_trad) REFERENCES public.language(id);


-- Completed on 2019-12-05 13:43:39

--
-- PostgreSQL database dump complete
--


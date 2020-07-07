--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7 (Debian 11.7-0+deb10u1)
-- Dumped by pg_dump version 11.7 (Debian 11.7-0+deb10u1)

-- Started on 2020-07-06 20:38:11 -04

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

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 24585)
-- Name: acta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.acta (
    codigo integer NOT NULL,
    descripcion character varying(255),
    estatus character(1),
    fecha timestamp without time zone,
    tipo integer,
    ult_actualizacion timestamp without time zone
);


ALTER TABLE public.acta OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 24590)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 2898 (class 0 OID 24585)
-- Dependencies: 196
-- Data for Name: acta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.acta (codigo, descripcion, estatus, fecha, tipo, ult_actualizacion) FROM stdin;
1	Lo que sea	A	2020-07-01 21:00:29.914	1	2020-07-01 21:00:29.914
4	El virus chino dice el Trompeto ese	I	2020-07-01 21:06:10.696	\N	2020-07-01 21:22:53.471
3	El virus chino dice el Trompeto ese	I	2020-07-01 21:05:07.835	1	2020-07-02 00:17:01.351
2	El virus chino dice el Trompeto ese	I	\N	\N	2020-07-02 00:17:23.004
\.


--
-- TOC entry 2905 (class 0 OID 0)
-- Dependencies: 197
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 5, true);


--
-- TOC entry 2776 (class 2606 OID 24589)
-- Name: acta acta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.acta
    ADD CONSTRAINT acta_pkey PRIMARY KEY (codigo);


-- Completed on 2020-07-06 20:38:11 -04

--
-- PostgreSQL database dump complete
--


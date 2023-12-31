PGDMP         +                z           error404     14.5 (Ubuntu 14.5-1.pgdg20.04+1)     14.5 (Ubuntu 14.5-1.pgdg20.04+1)                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16384    error404    DATABASE     ]   CREATE DATABASE error404 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'it_IT.UTF-8';
    DROP DATABASE error404;
                postgres    false            �            1259    16385    prodotti    TABLE       CREATE TABLE public.prodotti (
    id integer NOT NULL,
    id_utente bigint,
    nome character varying(50),
    descrizione character varying(250),
    foto character varying(50),
    data_scadenza date,
    quantita integer,
    prezzo double precision
);
    DROP TABLE public.prodotti;
       public         heap    postgres    false            �            1259    16388    prodotti_id_seq    SEQUENCE     �   CREATE SEQUENCE public.prodotti_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.prodotti_id_seq;
       public          postgres    false    209                       0    0    prodotti_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.prodotti_id_seq OWNED BY public.prodotti.id;
          public          postgres    false    210            �            1259    16389    utenti    TABLE       CREATE TABLE public.utenti (
    id integer NOT NULL,
    username character varying(50),
    password character varying(50),
    nome character varying(50),
    cognome character varying(50),
    citta character varying(50),
    email character varying(50)
);
    DROP TABLE public.utenti;
       public         heap    postgres    false            �            1259    16392    utenti_id_seq    SEQUENCE     �   CREATE SEQUENCE public.utenti_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.utenti_id_seq;
       public          postgres    false    211                       0    0    utenti_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.utenti_id_seq OWNED BY public.utenti.id;
          public          postgres    false    212            k           2604    16393    prodotti id    DEFAULT     j   ALTER TABLE ONLY public.prodotti ALTER COLUMN id SET DEFAULT nextval('public.prodotti_id_seq'::regclass);
 :   ALTER TABLE public.prodotti ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209            l           2604    16394 	   utenti id    DEFAULT     f   ALTER TABLE ONLY public.utenti ALTER COLUMN id SET DEFAULT nextval('public.utenti_id_seq'::regclass);
 8   ALTER TABLE public.utenti ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211            �          0    16385    prodotti 
   TABLE DATA           k   COPY public.prodotti (id, id_utente, nome, descrizione, foto, data_scadenza, quantita, prezzo) FROM stdin;
    public          postgres    false    209   �       �          0    16389    utenti 
   TABLE DATA           U   COPY public.utenti (id, username, password, nome, cognome, citta, email) FROM stdin;
    public          postgres    false    211   �       	           0    0    prodotti_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.prodotti_id_seq', 6, false);
          public          postgres    false    210            
           0    0    utenti_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.utenti_id_seq', 4, true);
          public          postgres    false    212            n           2606    16396    prodotti prodotti_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.prodotti
    ADD CONSTRAINT prodotti_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.prodotti DROP CONSTRAINT prodotti_pkey;
       public            postgres    false    209            p           2606    16398    utenti utenti_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.utenti
    ADD CONSTRAINT utenti_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.utenti DROP CONSTRAINT utenti_pkey;
       public            postgres    false    211            q           2606    16399     prodotti prodotti_id_utente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.prodotti
    ADD CONSTRAINT prodotti_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES public.utenti(id) ON UPDATE CASCADE;
 J   ALTER TABLE ONLY public.prodotti DROP CONSTRAINT prodotti_id_utente_fkey;
       public          postgres    false    209    3184    211            �   �  x�ŒM��@���)� �q�3�DbX�@b˦bW<��܎PN�a��\���D�Ė]�]?�{U�jWq�}az:+���'-��?��l�$��tT/xמiC�LфL��d�9�	yN���J��)?�la�q�ŧ�{\�(�i�?+�����H����/�KP��jLSGi	Qn���t�Hh�Ʊ���m�ݡz[u��d.��1La���r���z/N/f�O�H�h���S�d�2zQ�y�0���8�td;� Y1��O'� F�	b�wPPE�	����%�������n�ރ�m����C��;;�>
h�!:L7��<� ��l�Z�k=#%oQ��ʁC<��ן�����]�и[8$� }V��Xҏ<�0rY0��Z����m��v�á> ��	=->GŭTpQ<'���F���,���\�3�����D;h��KK��$�fA��P�5�`����Ed�Q�Khq`Y[�<��w���u�'�y�z5nF�Fv�>k���u���Y�      �   �   x�M˱
� ���|�������i�.��=P4y�&������i�� R�d�_�-8�G���:�Q��r��(	�y7�j�0�:*�Eiݥ��=܃+��\�I�<As)ہ�����q�ǐ~�A�N�tJJ�     
create database lojas;

use lojas;

CREATE TABLE produtos (
 nome varchar(100) not null,
 sku int not null,
 price int not null,
 quantity int not null,
 categories varchar(50) not null,
 description varchar(100) not null
);

CREATE TABLE categorias(
codigo int not null,
nome varchar(100)
);

select * from produtos;

select * from categorias;


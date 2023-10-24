FROM php:8.0-apache

WORKDIR /var/www/html-dynamics

RUN docker-php-ext-install mysqli

COPY ports.conf /etc/apache2/ports.conf

COPY 000-default.conf /etc/apache2/sites-available/000-default.conf

COPY apache2.conf /etc/apache2/apache2.conf

RUN a2emod authn_dbd && \ 
    apt-get update && \
    apt-get install -y apache2-utils libaprutil1-dbd-mysqli

EXPOSE 8081
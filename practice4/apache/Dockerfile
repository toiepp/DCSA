FROM php:8.0-apache

WORKDIR /var/www/html/

RUN docker-php-ext-install mysqli && \
    a2enmod authn_dbd && \
    apt-get update && \
    apt-get install -y libaprutil1-dbd-mysql && \
    service apache2 restart

# COPY . .

# RUN echo "ServerName localhost" >> /etc/apache2/000-default.conf
# RUN service apache2 restart



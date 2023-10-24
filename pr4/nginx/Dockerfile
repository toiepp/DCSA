FROM nginx

WORKDIR /usr/share/nginx/html-static

COPY nginx.conf /etc/nginx/conf.d/nginx.conf;

CMD ["nginx", "-g", "deamon off;"]

EXPOSE 8080
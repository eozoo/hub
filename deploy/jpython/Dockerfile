FROM ubuntu:20.04

RUN mkdir -p /usr/share/fonts/simsun
ADD simsun.ttf /usr/share/fonts/simsun

RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo 'Asia/Shanghai' > /etc/timezone \
    && apt-get update \
    && apt-get install -y vim tar gzip curl wget net-tools iputils-ping netcat \
    && apt-get install -y ttf-mscorefonts-installer fontconfig \
    && apt-get install -y openjdk-17-jdk python3 python3-pip python3-venv \
    && chmod -R 755 /usr/share/fonts/simsun \
    && mkfontscale \
    && mkfontdir \
    && fc-cache -fv \
    && rm -rf /var/lib/apt/lists/* \
    && apt-get clean \
    && ln -sf /usr/bin/python3 /usr/bin/python

ENV TZ Asia/Shanghai
ENV LANG C.UTF-8

WORKDIR /opt

CMD ["sleep", "infinity"]

# docker build -t jpython:17-3.14 .
# docker run -it jpython:17-3.14 /bin/bash

#!/usr/bin/env bash
docker run -v /opt/DONDE/:/opt/DONDE/ -m=4096m -dit -e TZ=America/Mexico_City --restart=always -p 8071:8080 --name aml-cargas-donde -d aml/cargas-donde:1.0 date

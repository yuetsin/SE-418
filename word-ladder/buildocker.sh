#!/usr/bin/env bash 

# Clean & Package
./mvnw clean package

# Generate docker image
./mvnw install dockerfile:build

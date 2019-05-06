# SE-418
Repository for `SE-418`，「软件产品设计与用户体验」。

## Project 1
Word Ladder Project based on SpringBoot.


## Project 2
SJTU Website Anatomy Report.

> Look [here](https://github.com/yuxiqian/SE-418/blob/master/sjtu-website-anatomy/document.md)

## Project 3 · [![Build Status](https://travis-ci.com/yuxiqian/SE-418.svg?branch=master)](https://travis-ci.com/yuxiqian/SE-418)  ![Coverage Status](https://coveralls.io/repos/github/yuxiqian/SE-418/badge.svg?branch=master)

Word Ladder Project with fore-end web pages.



## Project 4
Usage of Spring Security.

* Notice: Use test account `{ user, user_password }` as USER role to log into the console.

Use test account `{ admin, admin_password }` as ADMIN role to log into the console.

## Project 5 · ![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/yuxiqian/word-ladder.svg) ![Docker Pulls](https://img.shields.io/docker/pulls/yuxiqian/word-ladder.svg)

Dockerize

See [yuxiqian/word-ladder](https://hub.docker.com/r/yuxiqian/word-ladder) @ Docker Hub

Run 
``` shell
docker pull yuxiqian/word-ladder:latest
```
to pull the docker image.

Run
``` shell
docker run -p 8080:8080 -t yuxiqian/word-ladder
```
to run the docker image.

## Project 6

### Docker Images
    
    The original docker image has been split into two separate micro-services.

 * Login Manager Service Docker · ![Docker Pulls](https://img.shields.io/docker/pulls/yuxiqian/word-ladder.svg)

 * Ladder Calculating Service Docker · ![Docker Pulls](https://img.shields.io/docker/pulls/yuxiqian/word-ladder-prac.svg)

### Tests

    The Ladder Calculating Service has been deployed to [http://47.103.66.98:8080](http://47.103.66.98:8080), based on Ali Cloud Service.

    The link won't expire until `2019/5/14 00:00`.
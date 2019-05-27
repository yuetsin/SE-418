# Spring Cloud, Hystrix, and Feign

> #0: Before these

The most common needed in the actual web world is: When we want to access some serialized data, we don't want to encode these in parameters. We may handle them in this way: 

`https://www.bilibili.com/video/av53457956/`

Encode that serialized number in the @GetMapping, which is much cleaner and simpler.

The common syntax is:

``` java
@GetMapping("/addup/{number}/{plus}")
    String sumUp(@PathVariable("number") Integer number, @PathVariable("plus") Integer plus);
```
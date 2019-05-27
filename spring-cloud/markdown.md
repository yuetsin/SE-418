# Spring Cloud, Hystrix, and Feign

## \#0: Before these

The most common needed in the actual web world is: When we want to access some serialized data, we don't want to encode these in parameters. We may handle them in this way: 

`https://www.bilibili.com/video/av53457956/`

Encode that serialized number in the `@GetMapping`, which is much cleaner and simpler.

The common syntax is:

``` java
@GetMapping("/addup/{number}/{plus}")
    String sumUp(@PathVariable("number") Integer number, @PathVariable("plus") Integer plus);
```

It is not specific for Feign, just writing that down to memorize.

## \#1: Scheduling Requests

All started with that:

``` xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
    <version>2.1.1.RELEASE</version>
</dependency>
```

And we also need to add this annotations before the `MainApplication` class:

``` java
@EnableFeignClients
```

And that's it.

## \#2: Feign's Configuration

![Refer Image](https://xli1224.github.io/assets/2017-09-22-feign-client-configure/3EA965E3-D9D1-48C7-87DE-B3BE3CAB008E.png)

As picture showing, Feign Client's Configuration cares about every HttpRequest. However, not every request can be successful. So we need to configure a retry layer to handle the possible failure situation. The innest layer is `Feign` / `Ribbon` Configuraion. Under this layer we can configure these:

* Request Timeout
* Fallback Timeout
* Circuit Breaker

The standard configuration can be implemented in .properties files. Also it can be implemented with `@Configuraion` and `@Bean`.

``` java
@Configuration
public class FeignClientConfiguration {
    @Bean
    public Request.Options options() {
        return new Request.Options(
                6000,
                6000
        );
    }
}
```
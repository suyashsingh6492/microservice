package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/bank/accounts/**") //external client might invoke this path
                        .filters(f ->
                                // after this prefix path, like bank/accounts, whatever
                                //path is available, please assume that as an segment
                                //Using the same segment value I want the request to be forwarded to the actual microservice.

                                f.rewritePath("/bank/accounts/(?<segment>.*)", "/${segment}")
                                        .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        //we are going to provide the configurations to which microservice the request has to be redirected.
                        //please do the client side load balancer with the help of spring cloud load balancer. And post that we
                        //need to mention the application name at the microservice name that is registered with the Eureka Server.
                        .uri("lb://ACCOUNTS"))
                //we can try to disable all these default behavior, so set         locator:enabled: false
                .route(p -> p
                        .path("/bank/loans/**")
                        .filters(f -> f.rewritePath("/bank/loans/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://LOANS"))
                .route(p -> p
                        .path("/bank/cards/**")
                        .filters(f -> f.rewritePath("/bank/cards/(?<segment>.*)", "/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                        .uri("lb://CARDS")).build();

    }

}

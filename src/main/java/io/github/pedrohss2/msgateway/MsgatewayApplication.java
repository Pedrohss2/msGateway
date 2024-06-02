package io.github.pedrohss2.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class MsgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator locator(RouteLocatorBuilder builder)  {
		return builder
				.routes()
				.route(r -> r.path("/clientes/**").uri("lb://msclientes"))
				.route(r -> r.path("/cartoes/**").uri("lb://mscartoes"))
				.route(r -> r.path("/avaliacoes-credito/**").uri("lb://msavaliadordecreditos"))
				.route(r -> r.path("/solicitacao-cartao/**").uri("lb://msavaliadordecreditos"))
				.build();
	}

}
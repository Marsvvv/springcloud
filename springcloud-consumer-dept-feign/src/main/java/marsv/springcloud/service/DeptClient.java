package marsv.springcloud.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DeptClient {

    public static void main(String[] args) {
        SpringApplication.run(DeptClient.class, args);
    }
}

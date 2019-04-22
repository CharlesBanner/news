package com.charles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: GanZiB
 * Date: 2019-04-19
 * Time: 14:23
 */
@EnableEurekaServer
@SpringBootApplication
public class RegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class);
    }

}

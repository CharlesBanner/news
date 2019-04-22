package com.charles.configuration;

import com.charles.advice.EncryptRequestBodyAdvice;
import com.charles.advice.EncryptResponseBodyAdvice;
import com.charles.properties.EncryptProperties;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootConfiguration
@Component
@EnableAutoConfiguration
@EnableConfigurationProperties(EncryptProperties.class)
public class EncryptAutoConfiguration {

    /**
     * 配置请求解密
     * @return
     */
    @Bean
    public EncryptResponseBodyAdvice encryptResponseBodyAdvice() {
        return new EncryptResponseBodyAdvice();
    }

    /**
     * 配置请求加密
     * @return
     */
    @Bean
    public EncryptRequestBodyAdvice encryptRequestBodyAdvice() {
        return new EncryptRequestBodyAdvice();
    }
}

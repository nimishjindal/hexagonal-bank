package com.nimish.hexagonalbanking.bootstrap.config;

import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.infrastructure.repository.JpaAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.nimish.hexagonalbanking.infrastructure")
@EnableJpaRepositories(basePackages = "com.nimish.hexagonalbanking.infrastructure.repository")
public class AccountConfig implements WebMvcConfigurer {

    private JpaAccountRepository jpaAccountRepository;

    public AccountConfig(JpaAccountRepository jpaAccountRepository) {
        this.jpaAccountRepository = jpaAccountRepository;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**")
                .addResourceLocations("/WEB-INF/pdf/");
    }

    @Bean
    public AccountService accountService(){
        return new AccountService(jpaAccountRepository);
    }

}

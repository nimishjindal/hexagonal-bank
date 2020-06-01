package com.nimish.hexagonalbanking.infrastructure;

import com.nimish.hexagonalbanking.domain.AccountService;
import com.nimish.hexagonalbanking.infrastructure.repository.JpaAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
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

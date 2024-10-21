package com.grepp.todo.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class SwaggerConfig:WebMvcConfigurer {
    @Bean
    fun swaggerAPI() : OpenAPI{
        val info = Info()
            .title("Programmer 백엔드 데브코스 API ㅋㅋㅋ")
            .description("우리 서비스 설명이 들어갑니당?")
            .version("v87.0.u14")
        return OpenAPI().info(info)
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000") // ex) front 서버 오리진
            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true)
    }
}
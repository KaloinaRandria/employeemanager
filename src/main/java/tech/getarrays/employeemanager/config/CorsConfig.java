package tech.getarrays.employeemanager.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
		public CorsFilter corsFilter() {
			CorsConfiguration corsConfiguration = new CorsConfiguration();
			corsConfiguration.setAllowCredentials(true);
			corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
			corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Access-Control-Allow-Origin",
					"Accept","Authorization", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
			corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Access-Control-Allow-Credentials",
					"Access-Control-Allow-Origin", "Access-Control-Request-Credentials"));
			corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
			UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
			urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
			return new CorsFilter(urlBasedCorsConfigurationSource);
		}
}

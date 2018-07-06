package vn.topica.sf18.api.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CompositeFilter;
import vn.topica.sf18.api.auth.MyUrlAuthenticationSuccessHandler;

@EnableWebSecurity
@EnableOAuth2Client
@Slf4j
public class OauthConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private Environment environment;

  @Autowired
  private OAuth2ClientContext oauth2ClientContext;

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    log.info("set password encoder");
    auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    final CorsConfiguration configuration = new CorsConfiguration();
    configuration.addAllowedHeader("*");
    configuration.setAllowedOrigins(Arrays.asList("*"));
    configuration
        .setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PATCH", "DELETE", "OPTIONS"));
    // setAllowCredentials(true) is important, otherwise:
    // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
    configuration.setAllowCredentials(true);
    // setAllowedHeaders is important! Without it, OPTIONS preflight request
    // will fail with 403 Invalid CORS request
    configuration
        .setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
    configuration.setExposedHeaders(Arrays.asList("Authorization"));
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    log.info("MY_CONFIGURATION");
    http.antMatcher("/**")
        .addFilterBefore(ssoFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers("/api/login**", "/public/**", "/api/**").permitAll()
        .anyRequest().authenticated().and()
        .logout().logoutSuccessUrl("/").permitAll().and()
        .csrf().disable();
  }

  private Filter ssoFilter() {
    CompositeFilter filter = new CompositeFilter();
    List<Filter> filters = new ArrayList<>();

    OAuth2ClientAuthenticationProcessingFilter googleFilter = new OAuth2ClientAuthenticationProcessingFilter(
        "/api/login/google");
    OAuth2RestTemplate googleTemplate = new OAuth2RestTemplate(google(), oauth2ClientContext);
    googleFilter.setRestTemplate(googleTemplate);
    UserInfoTokenServices tokenServices = new UserInfoTokenServices(
        googleResource().getUserInfoUri(), google().getClientId());
    tokenServices.setRestTemplate(googleTemplate);
    googleFilter.setTokenServices(tokenServices);
    googleFilter.setAuthenticationSuccessHandler(successHandler());

    filters.add(googleFilter);

    filter.setFilters(filters);

    return filter;
  }

  @Bean
  public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(filter);
    registration.setOrder(-100);
    return registration;
  }

  @Bean
  @ConfigurationProperties("google.client")
  public AuthorizationCodeResourceDetails google() {
    return new AuthorizationCodeResourceDetails();
  }

  @Bean
  @ConfigurationProperties("google.resource")
  public ResourceServerProperties googleResource() {
    return new ResourceServerProperties();
  }

  private AuthenticationSuccessHandler successHandler() {
    return new MyUrlAuthenticationSuccessHandler(environment);
  }
}

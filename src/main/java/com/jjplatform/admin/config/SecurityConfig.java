package com.jjplatform.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration //이 클래스를 통해 bean 등록이나 각종 설정을 하겠다는 표시
public class SecurityConfig {

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
    
//    private static String[] ignoreStr = {"/css/**", "/js/**", "/vue/**", "/img/**", "/build/**", "/docs/**", "/src/**", "/vendors/**","/favicon.ico"};
    
    public void configure(WebSecurity web) {
    	// 허용 url 등록
    	web.ignoring().requestMatchers("/css/**", "/js/**", "/vue/**", "/img/**", "/build/**", "/docs/**", "/src/**", "/vendors/**","/favicon.ico");
    }

//    @SuppressWarnings("removal")
//	protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().ignoringRequestMatchers("/comm/**","/file/**")
//            .authorizeHttpRequests(request -> request
////            	.antMatchers("/", "/login").permitAll()
////                .antMatchers("/comm/**").hasRole("USER")
////                .anyRequest().permitAll()
//                .anyRequest().authenticated()
//             )
//            .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .defaultSuccessUrl("/main")
//            .and()
//            .logout()
//	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	            .logoutSuccessUrl("/")
//                .invalidateHttpSession(true) 	/*세션 삭제*/ 
//                .deleteCookies("JSESSIONID") 	/*쿠키 제거*/ 
//                .clearAuthentication(true) 		/*권한정보 제거*/
//                .permitAll()
//            .and()
//            .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler)
//            .and().sessionManagement() 
//            	.maximumSessions(1) 				/* session 허용 갯수 */ 
//                .expiredUrl("/logout ");			/* session 만료시 이동 페이지*/ 
////            	.expiredUrl("/logout"); 			/* session 만료시 이동 페이지*/ 
////		        .maxSessionsPreventsLogin(true); 	/* 동일한 사용자 로그인시 x, false 일 경우 기존 사용자 */
////        http.csrf().ignoringRequestMatchers("/comm/**","/file/**");
//    }

    /**
     * inMemory 방식
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//            .and()
//                .withUser("manager").password("password").roles("MANAGER");
        auth.authenticationProvider(authenticationProvider());
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrfConfig) ->
                    csrfConfig.disable()
            ) // 1번
            .headers((headerConfig) ->
                    headerConfig.frameOptions(frameOptionsConfig ->
                      			frameOptionsConfig.disable()
                    )
            )// 2번
            .authorizeHttpRequests((authorizeRequests) ->
                    authorizeRequests
//                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers("/css/**", "/js/**", "/vue/**", "/img/**", "/build/**", "/docs/**", "/src/**", "/vendors/**","/favicon.ico").permitAll()
//                        .requestMatchers("/posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
//                        .requestMatchers("/admins/**", "/api/v1/admins/**").hasRole(Role.ADMIN.name())
                        .anyRequest().authenticated()
            )// 3번
            .exceptionHandling((exceptionConfig) ->
//                    exceptionConfig.authenticationEntryPoint(unauthorizedEntryPoint)
//                    			   .accessDeniedHandler(accessDeniedHandler)
            	exceptionConfig.accessDeniedHandler(accessDeniedHandler)
            )// 401 403 관련 예외처리
            .formLogin((formLogin) ->
		            formLogin
	            		.loginPage("/login").permitAll()
//		                    .usernameParameter("username") 
//		                    .passwordParameter("password") 
//		                    .loginProcessingUrl("/login/login-proc") 
	                    .defaultSuccessUrl("/main", true) 
            )
		    .logout((logoutConfig) ->
		            logoutConfig
		            	.logoutSuccessUrl("/") 
			            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	//		            .logoutSuccessUrl("/")
		                .invalidateHttpSession(true) 	/*세션 삭제*/ 
		                .deleteCookies("JSESSIONID") 	/*쿠키 제거*/ 
		                .clearAuthentication(true) 		/*권한정보 제거*/
		                .permitAll()
		    )
		    .authenticationProvider(authenticationProvider())
		    ;

        return http.build();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }
    
    @Bean
    // BCryptPasswordEncoder는 Spring Security에서 제공하는 비밀번호 암호화 객체입니다.
    // Service에서 비밀번호를 암호화할 수 있도록 Bean으로 등록합니다.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
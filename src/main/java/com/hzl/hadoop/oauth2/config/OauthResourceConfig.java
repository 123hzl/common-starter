package com.hzl.hadoop.oauth2.config;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * description
 * 资源管理配置类
 *
 * @author hzl 2021/12/20 11:14 AM
 */
@Configuration
@EnableResourceServer
@AutoConfigureAfter(DynamicRoutingDataSource.class)
@ConditionalOnProperty(prefix = "hadoop", name = "isOauth2", havingValue = "true", matchIfMissing = true)
public class OauthResourceConfig extends ResourceServerConfigurerAdapter {

	/**
	 * 指定token的持久化策略
	 * 其下有   RedisTokenStore保存到redis中，
	 * JdbcTokenStore保存到数据库中，
	 * InMemoryTokenStore保存到内存中等实现类，
	 * 这里我们选择保存在数据库中
	 *
	 * @return
	 */

	@Autowired
	private DataSource dataSource;

	@Bean
	public TokenStore jdbcTokenStore() {
		return new JdbcTokenStore(dataSource);
	}


	@Qualifier("jdbcTokenStore")
	@Autowired
	private TokenStore tokenStore;


	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		//指定当前资源的id，非常重要！必须写！
		resources.resourceId("hadoop")
				//指定保存token的方式
				.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//指定不同请求方式访问资源所需要的权限，一般查询是read，其余是write。
				.antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasAnyScopeMatching('read','all')")
				.antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasAnyScopeMatching('write','all')")
				.antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasAnyScopeMatching('write','all')")
				.antMatchers(HttpMethod.PUT, "/**").access("#oauth2.hasAnyScopeMatching('write','all')")
				.antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasAnyScopeMatching('write','all')")
				.and()
				.headers().addHeaderWriter((request, response) -> {
			response.addHeader("Access-Control-Allow-Origin", "*");//允许跨域
			if (request.getMethod().equals("OPTIONS")) {//如果是跨域的预检请求，则原封不动向下传达请求头信息
				response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
				response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
			}
		});
	}


}

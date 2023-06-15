package com.fox.alibaba.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-03 19:32
* @version 1.0
*/
@Configuration
@MapperScan(basePackages = {"com.fox.alibaba.dao"}, sqlSessionTemplateRef = "sqlSessionTemplateOne")
public class DataSourceOneConfig {

  @Value("${mybatis.mapper-locations-One}")
  private String mapper_location;

  @Value("${mybatis.config-location}")
  private String mybatis_config;

  private Logger logger = LoggerFactory.getLogger(DataSourceOneConfig.class);

  @Primary
  @Bean(name = "datasourceOne")
  @ConfigurationProperties(prefix = "spring.datasource.druid.one")
  public DataSource datasourceOne() {
	  
      return DruidDataSourceBuilder.create().build();
  }

  @Bean
  public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("datasourceOne") DataSource dataSource) throws Exception {
      logger.info("mapper file location: " + mapper_location);
      logger.info("mybatis config file location: " + mybatis_config);
      SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
      bean.setDataSource(dataSource);
      bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_location));
      bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mybatis_config));
      return bean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("sqlSessionFactoryOne") SqlSessionFactory sqlSessionFactory) {
      SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
      return template;
  }

  @Bean
  public DataSourceTransactionManager transactionManagerOne(@Qualifier("datasourceOne") DataSource dataSource){
      return new DataSourceTransactionManager(dataSource);
  }
}

package com.fox.config;

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
* @date 2023-06-23 14:43
* @version 1.0
*/
@Configuration
@MapperScan(basePackages = {"com.fox.dao.two"}, sqlSessionTemplateRef = "sqlSessionTemplateTwo")
public class DataSourceTwoConfig {

  @Value("${mybatis.mapper-locations-Two}")
  private String mapper_location;

  @Value("${mybatis.config-location}")
  private String mybatis_config;

  private Logger logger = LoggerFactory.getLogger(DataSourceTwoConfig.class);

  @Primary //默认数据源
  @Bean(name = "datasourceTwo")
  @ConfigurationProperties(prefix = "spring.datasource.druid.two")
  public DataSource datasourceTwo() {
	  
      return DruidDataSourceBuilder.create().build();
  }

  @Bean
  @Primary //默认数据源
  public SqlSessionFactory sqlSessionFactoryTwo(@Qualifier("datasourceTwo") DataSource dataSource) throws Exception {
      logger.info("mapper file location: " + mapper_location);
      logger.info("mybatis config file location: " + mybatis_config);
      SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
      bean.setDataSource(dataSource);
      bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_location));
      bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mybatis_config));
      return bean.getObject();
  }

  @Bean
  @Primary //默认数据源
  public SqlSessionTemplate sqlSessionTemplateTwo(@Qualifier("sqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactory) {
      SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
      return template;
  }

  @Bean
  @Primary //默认数据源
  public DataSourceTransactionManager transactionManagerTwo(@Qualifier("datasourceTwo") DataSource dataSource){
      return new DataSourceTransactionManager(dataSource);
  }
}

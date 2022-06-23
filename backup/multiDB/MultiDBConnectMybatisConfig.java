package seongsland.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MultiDBConnectMybatisConfig {

	@Autowired
	private ApplicationContext applicationContext;

    @Bean(name = "db1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.db1.datasource")
    DataSource db1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db1SqlSessionFactory")
    @Primary
    SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource db1DataSource) throws Exception {
        SqlSessionFactoryBean ssfBean = new SqlSessionFactoryBean();
        ssfBean.setDataSource(db1DataSource);
        ssfBean.setTypeAliasesPackage("seongsland.domain");
        ssfBean.setMapperLocations(applicationContext.getResources("classpath:/sqlmap/mapper/*.xml"));
        return ssfBean.getObject();
    }

    @Bean(name = "db1")
    @Primary
    SqlSessionTemplate db1SqlSessionTemplate(SqlSessionFactory db1SqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(db1SqlSessionFactory);
    }

    @Bean(name = "db2DataSource")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    DataSource db2() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2SqlSessionFactory")
    SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource db2DataSource) throws Exception {
        SqlSessionFactoryBean ssfBean = new SqlSessionFactoryBean();
        ssfBean.setDataSource(db2DataSource);
        ssfBean.setTypeAliasesPackage("seongsland.domain");
        ssfBean.setMapperLocations(applicationContext.getResources("classpath:/sqlmap/mapper/*.xml"));
        return ssfBean.getObject();
    }

    @Bean(name = "db2")
    SqlSessionTemplate db2SqlSessionTemplate(SqlSessionFactory db2SqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(db2SqlSessionFactory);
    }
	
}
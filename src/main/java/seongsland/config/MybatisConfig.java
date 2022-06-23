package seongsland.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //factoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/sqlmap/config/mapper-config.xml"));
        Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources("classpath:/sqlmap/mapper/**/*_SQL.xml");
        factoryBean.setMapperLocations(mapperLocations);
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Lazy
    public DefaultLobHandler lobHandler() {
        return new DefaultLobHandler();
    }
}
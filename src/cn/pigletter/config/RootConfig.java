package cn.pigletter.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//数据源，事务控制

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "cn.pigletter", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class))
@MapperScan("cn.pigletter.dao")
@PropertySource("classpath:DBconfig.properties")
public class  RootConfig {


    @Autowired
    Environment env;

    //==================================================================================================================
    //和mybatis整合
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(pooledDataSource());
        factoryBean.setConfigLocation(new ClassPathResource("sqlMapConfig.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }


//    手动注册mapper
//    @Bean
//    public ArticleMapper articleDAO() throws Exception {
//        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
//        return sqlSessionTemplate.getMapper(ArticleMapper.class);
//    }

    //==================================================================================================================
    //数据源
    @Bean
    public PooledDataSource pooledDataSource(){
        PooledDataSource pooledDataSource=new PooledDataSource();
        pooledDataSource.setDriver(env.getProperty("jdbc.driver"));
        pooledDataSource.setUsername(env.getProperty("jdbc.username"));
        pooledDataSource.setPassword(env.getProperty("jdbc.password"));
        pooledDataSource.setUrl(env.getProperty("jdbc.url"));
        return  pooledDataSource;
    }

    //==================================================================================================================
    //事务控制
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(){
        return  new DataSourceTransactionManager(pooledDataSource());
    }



}

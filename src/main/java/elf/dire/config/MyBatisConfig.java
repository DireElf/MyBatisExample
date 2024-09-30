package elf.dire.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("elf.dire.mapper")
public class MyBatisConfig {
    /**
     * Создает бин SqlSessionFactory, используя DataSource (здесь это PostgreSQL).
     *
     * @param dataSource объект типа DataSource, предоставляющий источник данных
     * @return объект типа SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/*.xml"));
        return factoryBean.getObject();
    }
}

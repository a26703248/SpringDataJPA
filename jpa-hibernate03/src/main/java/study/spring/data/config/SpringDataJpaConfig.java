package study.spring.data.config;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "study.spring.data")
@EnableTransactionManagement
@EnableJpaAuditing
public class SpringDataJpaConfig {

  @Bean
  public DataSource dataSource() {
    ComboPooledDataSource cpds = new ComboPooledDataSource();
    try {
      cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
      cpds.setJdbcUrl(
          "jdbc:mysql://192.168.0.200:3306/spring_data?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true");
      cpds.setUser("developer");
      cpds.setPassword("a0909007892");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cpds;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);
    vendorAdapter.setShowSql(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("study.spring.data.pojo");
    factory.setDataSource(dataSource());
    return factory;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory);
    return txManager;
  }

  // 返回當前用戶
  @Bean
  public AuditorAware<String> auditorAware() {
    return new AuditorAware<String>() {

      @Override
      public Optional<String> getCurrentAuditor() {
        // 取得當前帳號
        return Optional.of("Keven");
      }

    };
  }

}

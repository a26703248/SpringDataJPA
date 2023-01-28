package study.spring.data.scan;

import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.AnnotationMetadata;

import study.spring.data.bean.JpaFactoryBean;

/*
 * 自訂掃描器
 */
public class JpaClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

  public JpaClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
    super(registry);
  }

  // 若類別為 interface 和繼承 Repository
  @Override
  protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
    AnnotationMetadata metadata = beanDefinition.getMetadata();
    return metadata.isInterface();
  }

  @Override
  protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
    Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
    beanDefinitionHolders.stream()
        .map(b -> (ScannedGenericBeanDefinition) b.getBeanDefinition())
        .forEach(beanDef -> {
          // 查詢 scan 內傳入的 bean class
          String beanClass = beanDef.getBeanClassName();
          // 傳入 bean class 建構子
          beanDef.getConstructorArgumentValues().addGenericArgumentValue(beanClass);
          // 替換掉 bean 中實體類別
          beanDef.setBeanClass(JpaFactoryBean.class);
        });
    return beanDefinitionHolders;
  }

}

package study.spring.data.bean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import study.spring.data.repository.MyHandle;

public class JpaFactoryBean implements FactoryBean {

  @Autowired
  LocalContainerEntityManagerFactoryBean emf;

  Class<?> repositoryInterface;

  public JpaFactoryBean(Class<?> repositoryInterface) {
    this.repositoryInterface = repositoryInterface;
  }

  @Override
  public Object getObject() throws Exception {

    // EntityManager
    EntityManager em = emf.createNativeEntityManager(null);

    ParameterizedType parameterizedType = (ParameterizedType) repositoryInterface.getGenericInterfaces()[0];
    Type type = parameterizedType.getActualTypeArguments()[0];
    Class clazz = Class.forName(type.getTypeName());

    return Proxy.newProxyInstance(
        repositoryInterface.getClassLoader(),
        new Class[] { repositoryInterface },
        new MyHandle(em, clazz));
  }

  @Override
  public Class getObjectType() {
    return repositoryInterface;
  }

}

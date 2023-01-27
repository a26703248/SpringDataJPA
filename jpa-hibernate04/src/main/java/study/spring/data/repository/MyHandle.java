package study.spring.data.repository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import javax.persistence.EntityManager;

public class MyHandle implements InvocationHandler {
  EntityManager em;
  Class pojoClass;

  public MyHandle() {
  }

  public MyHandle(EntityManager em, Class pojoClass) {
    this.em = em;
    this.pojoClass = pojoClass;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(method.getName());
    CustomerRepositoryProxy obj = new CustomerRepositoryProxy(em, pojoClass);
    Method targetMethod = obj.getClass().getMethod(method.getName(), method.getParameterTypes());
    return targetMethod.invoke(obj, args);
  }

}

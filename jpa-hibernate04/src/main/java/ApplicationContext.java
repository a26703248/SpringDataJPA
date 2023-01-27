import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import study.spring.data.config.SpringDataJpaConfig;
import study.spring.data.pojo.CustomerTwo;
import study.spring.data.repository.CustomerTwoRepository;

public class ApplicationContext {

  public static void main(String[] args) throws Exception {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDataJpaConfig.class);

    CustomerTwoRepository repository = context.getBean(CustomerTwoRepository.class);

    System.out.println(repository.getClass());
    Optional<CustomerTwo> findById = repository.findById(1L);
    System.out.println(findById.orElse(null));
  }

}

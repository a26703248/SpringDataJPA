package study.spring.data.pojo;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;


/**
 * QEmp is a Querydsl query type for Emp
 */
@javax.annotation.processing.Generated("com.querydsl.codegen.EntitySerializer")
public class QEmp extends EntityPathBase<Emp> {

    private static final long serialVersionUID = -358282778L;

    public static final QEmp emp = new QEmp("emp");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QEmp(String variable) {
        super(Emp.class, forVariable(variable));
    }

    public QEmp(Path<? extends Emp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmp(PathMetadata metadata) {
        super(Emp.class, metadata);
    }

}


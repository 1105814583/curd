import com.lee.ssm.dao.DeptMapper;
import com.lee.ssm.dao.EmpMapper;
import com.lee.ssm.entity.Dept;
import com.lee.ssm.entity.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @author lee
 * @version 2022/4/19 12:04
 * @since JDK8
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestMapper {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testInsert(){
       deptMapper.insertSelective(new Dept(null,"开发部"));
       deptMapper.insertSelective(new Dept(null,"测试部"));

    }

    @Test
    public void testInsertByBatch(){
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0,5)+i;
            int gender = random.nextInt(2);
            int dept = gender+1;
            mapper.insertSelective(new Emp(null,uuid,gender==0?"男":"女","@qq.com",dept==1?1:2));
        }
        System.out.println("批量添加完成!");

    }


}

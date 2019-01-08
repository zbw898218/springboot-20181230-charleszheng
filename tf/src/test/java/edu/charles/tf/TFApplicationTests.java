package edu.charles.tf;

import edu.charles.tf.enums.SexEnum;
import edu.charles.tf.enums.TypeEnum;
import edu.charles.tf.entity.CustomerEntity;
import edu.charles.tf.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TFApplicationTests {
    @Autowired
    private CustomerService customerService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test() {
        CustomerEntity entity=new CustomerEntity();
        entity.setAge(10);
        Date createTime=new Date(System.currentTimeMillis());
        entity.setCreateTime(createTime);
        entity.setName("张三");
        entity.setSex(SexEnum.FEMALE);
        entity.setDescription("hehe");
        entity.setType(TypeEnum.NORMAL);
        entity.setId(1l);
        Long id=customerService.addNewCustomer(entity);
        System.out.println(id);
    }

}


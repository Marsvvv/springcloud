package marsv.springcloud.controller;

import org.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

//    消费者，不应该有services层
    @Autowired
    private RestTemplate restTemplate; // 提供多种便捷访问远程Http服务的方法，简单的Restful服务模板

//    Ribbon 我们的地址应该是变量，而不是常量，我们需要去不同的Server中
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable("id") Long deptno) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/"+deptno, Dept.class);
    }

    @RequestMapping("/consumer/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }

    @RequestMapping("/consumer/add")
    public Boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }
}

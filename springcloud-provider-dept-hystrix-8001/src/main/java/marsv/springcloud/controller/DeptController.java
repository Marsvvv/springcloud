package marsv.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import marsv.springcloud.service.DeptService;
import org.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 提供Restful服务
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long deptno) {
        Dept dept = deptService.queryDept(deptno);
        if(dept == null) {
            throw new RuntimeException("id=>"+deptno+"用户未查到");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long deptno) {
        Dept dept = new Dept("操作失败或超时");
        return dept;
    }

    @GetMapping("dept/list")
    public List<Dept> getList() {
        return deptService.queryAll();
    }
}

package marsv.springcloud.controller;

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
    public Dept get(@PathVariable("id") Long deptno) {
        return deptService.queryDept(deptno);
    }

    @GetMapping("dept/list")
    public List<Dept> getList() {
        return deptService.queryAll();
    }
}

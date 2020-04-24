package marsv.springcloud.service;

import org.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 社区版人员认为Java中的调用应该是这样设计的
 * value中需要加入Client id进行查询所有的服务以及负载均衡
 */
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    public Dept queryById(Long deptno);

    public List<Dept> queryAll();

    public Dept add(Dept dept);
}

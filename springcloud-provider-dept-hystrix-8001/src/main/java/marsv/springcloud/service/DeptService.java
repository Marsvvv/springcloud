package marsv.springcloud.service;

import org.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept queryDept(Long deptno);

    public List<Dept> queryAll();
}

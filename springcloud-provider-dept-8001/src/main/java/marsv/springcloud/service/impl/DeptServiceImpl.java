package marsv.springcloud.service.impl;

import marsv.springcloud.dao.DeptDao;
import marsv.springcloud.service.DeptService;
import org.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryDept(Long deptno) {
        return deptDao.queryDept(deptno);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}

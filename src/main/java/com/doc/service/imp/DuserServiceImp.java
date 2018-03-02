package com.doc.service.imp;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.doc.mapper.DUserMapper;
import com.doc.model.DUser;
import com.doc.model.DUserExample;
import com.doc.service.DUserService;

/**
 * 说明：
 *
 * @Author: Alan
 * 2018-01-07  16:57:26
 * 星期日
 */
@Service
public class DuserServiceImp implements DUserService {
    @Resource
    private DUserMapper dUserMapper;




    public DUser uplogin(DUser dUser){
        DUserExample example =new DUserExample();
        DUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(dUser.getUsername());
        criteria.andPasswordEqualTo(dUser.getPassword());
        criteria.andStatusNotEqualTo(0);
        List<DUser> dUsers = dUserMapper.selectByExample(example);
        if (dUsers.size()==0) {
			return null;
		}
         
        return dUsers.get(0);
    }
    public DUser updateDuser(String name,String percent,int uid){
    	DUserExample example =new DUserExample();
    	DUserExample.Criteria criteria = example.createCriteria();
    	criteria.andStatusNotEqualTo(0);
    	criteria.andIdEqualTo(uid);
    	DUser user=new DUser();
    	user.setName(name);
    	user.setPercent(new BigDecimal(percent));
    	dUserMapper.updateByExampleSelective(user, example);
    	List<DUser> dUsers = dUserMapper.selectByExample(example);
    	if (dUsers.size()==0) {
    		return null;
    	}
    	
    	return dUsers.get(0);
    }
    public DUser updateDuser(String data2,int uid){
    	DUserExample example =new DUserExample();
    	DUserExample.Criteria criteria = example.createCriteria();
    	criteria.andStatusNotEqualTo(0);
    	criteria.andIdEqualTo(uid);
    	DUser user=new DUser();
    	user.setPassword(data2);
    	dUserMapper.updateByExampleSelective(user, example);
    	List<DUser> dUsers = dUserMapper.selectByExample(example);
    	if (dUsers.size()==0) {
    		return null;
    	}
    	
    	return dUsers.get(0);
    }
    public Integer uplogin(String username){
        DUserExample example =new DUserExample();
        DUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusNotEqualTo(0);
        List<DUser> dUsers = dUserMapper.selectByExample(example);
        if (dUsers.size()>0){
            return 1;
        }
        return 0;
    }





}

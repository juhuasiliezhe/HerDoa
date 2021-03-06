package com.doc.service.imp;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import com.doc.mapper.DPatientMapper;
import com.doc.model.DPatient;
import com.doc.model.DPatientExample;
import com.doc.model.DPatientExample.Criteria;
import com.doc.service.DPatientService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明：
 *
 * @Author: Alan
 * 2018-01-07  16:57:26
 * 星期日
 */
@Service
public class DPatientServiceImp  implements DPatientService{
    @Resource
    private DPatientMapper dPatientMapper;


    public List<DPatient> queryAllPatient( int did,int pageNum,int pageSize,String order,String name){
        PageHelper page=new PageHelper();
        page.startPage(pageNum, pageSize);
        DPatientExample example=new DPatientExample();
    	Criteria createCriteria = example.createCriteria();
    	createCriteria.andDidEqualTo(did);
    	example.setOrderByClause(order);
    	if (name.length()>0) {
    		createCriteria.andNameLike("%"+name+"%");
			
		}
//        List<DPatient> allByOrder = dPatientMapper.findAllByOrder(order,did);
    	List<DPatient> selectByExample = dPatientMapper.selectByExample(example);
        return  selectByExample;
    }
    public DPatient queryOnePatient( int id){
    	DPatientExample example=new DPatientExample();
    	Criteria createCriteria = example.createCriteria();
    	createCriteria.andIdEqualTo(id);
    	List<DPatient> allByOrder = dPatientMapper.selectByExample(example);
    	return  allByOrder.get(0);
    }

    public void  addPatient(DPatient dPatient){
        dPatientMapper.insertSelective(dPatient);
    }
    
    
    
    
    public Integer updatePatient(DPatient dPatient,int did){
    	DPatientExample example1=new DPatientExample();
    	Criteria createCriteria1 = example1.createCriteria();
    	createCriteria1.andIdEqualTo(dPatient.getId());
    	createCriteria1.andDidEqualTo(did);
    	List<DPatient> selectByExample = dPatientMapper.selectByExample(example1);
    	if (selectByExample.size()>0) {
    		DPatientExample example=new DPatientExample();
        	Criteria createCriteria = example.createCriteria();
        	createCriteria.andIdEqualTo(dPatient.getId());
        	return dPatientMapper.updateByExampleSelective(dPatient, example);
    		
			
		}
    	
    	return -1;
    }


}

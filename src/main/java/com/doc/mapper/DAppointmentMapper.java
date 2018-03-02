package com.doc.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import com.doc.model.DAppointment;
import com.doc.model.countBytime;
import com.doc.util.MyMapper;

import java.util.Date;
import java.util.List;

public interface DAppointmentMapper  extends MyMapper<DAppointment> {

    @Select("SELECT * FROM d_appointment where 1=1 and status!=0 and did = #{did}   order by   #{myorder}")
    @ResultType(DAppointment.class)
    List<DAppointment> findAllByOrder(@Param("myorder") String myorder,@Param("did") Integer did);
    
    
    @Select("SELECT SUM(getmoney)getmoney,SUM(putmoney)putmoney ,percent from " +
    		"d_appointment a,d_user b where did=#{did} and b.id=did and a.uptime BETWEEN  #{startTime} and #{endTime}")
    @ResultType(countBytime.class)
    countBytime countWithTime(@Param("did") Integer did,@Param("startTime") Date startTime,@Param("endTime") Date endTime);


}
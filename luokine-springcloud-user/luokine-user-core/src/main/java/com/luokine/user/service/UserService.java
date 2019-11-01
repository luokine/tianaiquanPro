package com.luokine.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luokine.common.model.Vo.Resp;
import com.luokine.common.orm.service.BaseService;
import com.luokine.user.bean.UserInfo;
import com.luokine.user.query.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService extends BaseService<UserInfo> {

    IPage<UserInfo> getUserList(UserVo user);

    Resp<Boolean> batchInsertUser(Integer num,Integer index);

    List<UserInfo> getUserInfoList();

    UserInfo getUserInfoByName(String name);

    UserInfo getListById(Integer id);
}

package com.raise.pigs.service.service.impl;

import com.raise.pigs.service.entity.Staff;
import com.raise.pigs.service.mapper.StaffMapper;
import com.raise.pigs.service.service.IStaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements IStaffService {

}

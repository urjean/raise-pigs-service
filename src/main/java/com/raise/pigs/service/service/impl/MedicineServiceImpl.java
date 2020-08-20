package com.raise.pigs.service.service.impl;

import com.raise.pigs.service.entity.Medicine;
import com.raise.pigs.service.mapper.MedicineMapper;
import com.raise.pigs.service.service.IMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 药品表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-20
 */
@Service
public class MedicineServiceImpl extends ServiceImpl<MedicineMapper, Medicine> implements IMedicineService {

}

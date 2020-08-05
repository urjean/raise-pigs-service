package com.raise.pigs.service.service.impl;

import com.raise.pigs.service.entity.Feed;
import com.raise.pigs.service.mapper.FeedMapper;
import com.raise.pigs.service.service.IFeedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 饲料表 服务实现类
 * </p>
 *
 * @author osumg
 * @since 2020-08-05
 */
@Service
public class FeedServiceImpl extends ServiceImpl<FeedMapper, Feed> implements IFeedService {

}

package com.unbeaten.wiki.service.impl;

import com.sun.org.glassfish.external.statistics.Statistic;
import com.unbeaten.wiki.mapper.EbookSnapshotMapperCust;
import com.unbeaten.wiki.resp.StatisticResp;
import com.unbeaten.wiki.service.IEbookSnapshotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 电子书快照表 服务实现类
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-04
 */
@Service
public class EbookSnapshotServiceImpl  implements IEbookSnapshotService {

    @Resource
    private EbookSnapshotMapperCust ebookSnapshotMapperCust;

    @Override
    public void genSnapshot() {
        ebookSnapshotMapperCust.genSnapshot();
    }

    @Override
    /**
     * 获取首页数值数据：日期、总阅读数、总点赞数、今日阅读数、今日点赞数
     */
    public List<StatisticResp> getStatistic() {
        return ebookSnapshotMapperCust.getStatistic();
    }

    @Override
    public List<StatisticResp> get30Statistic() {
        return ebookSnapshotMapperCust.get30Statistic();
    }
}

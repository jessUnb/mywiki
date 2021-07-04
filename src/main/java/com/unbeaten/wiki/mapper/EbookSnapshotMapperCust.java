package com.unbeaten.wiki.mapper;

import com.sun.org.glassfish.external.statistics.Statistic;
import com.unbeaten.wiki.resp.StatisticResp;

import java.util.List;

/**
 * <p>
 * 电子书快照表 Mapper 接口
 * </p>
 *
 * @author unbeaten
 * @since 2021-07-04
 */
public interface EbookSnapshotMapperCust{

    void genSnapshot();

    List<StatisticResp> getStatistic();

    List<StatisticResp> get30Statistic();
}

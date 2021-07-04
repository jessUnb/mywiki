package com.unbeaten.wiki.mapper;

import com.sun.org.glassfish.external.statistics.Statistic;

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

    public void genSnapshot();

    List<Statistic> getStatistic();
}

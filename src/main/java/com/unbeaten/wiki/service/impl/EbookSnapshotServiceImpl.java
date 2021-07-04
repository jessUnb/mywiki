package com.unbeaten.wiki.service.impl;

import com.unbeaten.wiki.domain.EbookSnapshot;
import com.unbeaten.wiki.mapper.EbookSnapshotMapperCust;
import com.unbeaten.wiki.service.IEbookSnapshotService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}

package org.feather.es.service;

import org.elasticsearch.client.license.LicensesStatus;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @projectName: elasticsearch-job
 * @package: org.feather.es.service
 * @className: PositionService
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/9/6 21:23
 * @version: 1.0
 */
public interface PositionService {
    /**
     * 倒入数据
     */
    void  importAll();

    /**
     * 分页查询
     * @param keyWords
     * @param pageNo
     * @param pageSize
     * @return
     */
      List<Map<String, Object>> searchPos(String keyWords,int pageNo,int pageSize) throws IOException;
}

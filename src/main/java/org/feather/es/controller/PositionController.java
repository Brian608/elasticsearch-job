package org.feather.es.controller;

import org.feather.es.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @projectName: elasticsearch-job
 * @package: org.feather.es.controller
 * @className: PositionController
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/9/6 22:14
 * @version: 1.0
 */
@RequestMapping("/position")
@RestController
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping({"/","index"})
    public String  indexPage(){
        return "index";
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> searchPosition(@PathVariable("keyword") String keyword,
                                                     @PathVariable("pageNo") int pageNo,
                                                     @PathVariable("pageSize") int pageSize) throws IOException {
        return  positionService.searchPos(keyword,pageNo,pageSize);
    }

    @RequestMapping("/importAll")
    public String importAll(){
        positionService.importAll();
        return "success";
    }
}

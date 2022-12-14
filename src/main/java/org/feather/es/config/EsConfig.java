package org.feather.es.config;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @projectName: elasticsearch-job
 * @package: org.feather.es.config
 * @className: EsConfig
 * @author: feather(杜雪松)
 * @description: TODO
 * @since: 2022/9/6 21:15
 * @version: 1.0
 */
@Configuration
public class EsConfig {
    @Value("${spring.elasticsearch.rest.uris}")
    private  String  hostList;
    @Bean
    public RestHighLevelClient client() {
        //解析hostList配置信息
        String[] split = hostList.split(",");
        //创建HttpHost数组，其中存放es主机和端口的配置信息
        HttpHost[] httpHostArray = new HttpHost[split.length];
        for(int i=0;i<split.length;i++){
            String item = split[i];
            System.out.println(item);
            httpHostArray[i] = new HttpHost(item.split(":")[0], Integer.parseInt(item.split(":")[1]), "http");
        }
        //创建RestHighLevelClient客户端
        return new RestHighLevelClient(RestClient.builder(httpHostArray));
    }
}

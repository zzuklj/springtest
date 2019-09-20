package com.klj.springtest.extend.tool;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;

public class EsKit {

    private static final String IP = "192.168.137.55";

    static ElasticsearchTemplate template;
    static TransportClient transportClient;

   static {
       Settings settings = Settings
               .builder()
               .put("cluster.name", "my-es-cluster")
               .put("client.transport.sniff", true)
               .build();
       PreBuiltTransportClient preBuiltTransportClient = new PreBuiltTransportClient(settings);
       try {
           transportClient = preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), 9300));
       } catch (UnknownHostException e) {
           e.printStackTrace();
       }

       /*template = new ElasticsearchTemplate(transportClient);*/
    }

    @Test
    public void query(){

        SearchResponse response = transportClient.prepareSearch("info_document").setQuery(QueryBuilders.fuzzyQuery("fileName", "组织")).get();
        SearchHit[] hits = response.getHits().getHits();


        /*NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withIndices("info_document");

        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        MatchQueryBuilder queryBuilder =null;
        queryBuilder = QueryBuilders.matchQuery("fileName", "组织")
                .minimumShouldMatch("2")
                .boost(5L);
        boolBuilder.must(queryBuilder);

        long count = template.count(nativeSearchQueryBuilder.build());
        nativeSearchQueryBuilder.withPageable(PageRequest.of(0, 10));
        SearchResponse response = template.query(nativeSearchQueryBuilder.build(), (a) -> a);
        SearchHits hits = response.getHits();*/
        Arrays.stream(hits).forEach(e -> {
            Map<String, Object> sourceAsMap = e.getSourceAsMap();
            String fileName = (String) sourceAsMap.get("fileName");
            System.out.println(fileName);
        });
    }

}

package com.klj.springtest;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsOperationTest {

    @Autowired
    ElasticsearchTemplate template;

    @Test
    public void query(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withIndices("info_document");

        BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
        MatchQueryBuilder queryBuilder =null;
        queryBuilder = QueryBuilders.matchQuery("fileName", "组织")
                .minimumShouldMatch("2")
                .boost(5L);
        boolBuilder.must(queryBuilder);

        NativeSearchQuery query = nativeSearchQueryBuilder.withQuery(boolBuilder).build();
        long count = template.count(query);
        nativeSearchQueryBuilder.withPageable(PageRequest.of(0, 10));
        SearchResponse response = template.query(query, (a) -> a);
        SearchHits hits = response.getHits();
        Arrays.stream(hits.getHits()).forEach(e -> {
            Map<String, Object> sourceAsMap = e.getSourceAsMap();
            String fileName = (String) sourceAsMap.get("fileName");
            System.out.println(fileName);
        });
    }
}

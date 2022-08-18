package org.lili.graphql.service;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * @author lili
 * @date 2022/8/18 20:58
 */
@GraphQLApi
@Service
public class ProjectService {

    @GraphQLQuery
    public List<String> list(LocalDate s) {
        return Collections.emptyList();
    }
}

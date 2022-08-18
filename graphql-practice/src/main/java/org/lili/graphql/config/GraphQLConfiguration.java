package org.lili.graphql.config;

import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import io.leangen.graphql.spqr.spring.annotations.WithResolverBuilder;
import org.lili.graphql.service.ProjectService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lili
 * @date 2022/8/18 21:05
 */
@Configuration
public class GraphQLConfiguration {

//    @GraphQLApi
//    @WithResolverBuilder(PublicResolverBuilder.class)
//    @Bean
//    public ProjectService projectService() {
//        return new ProjectService();
//    }
}

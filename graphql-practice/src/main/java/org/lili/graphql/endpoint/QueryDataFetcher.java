package org.lili.graphql.endpoint;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.lili.graphql.config.CoreConfig;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@GraphQLApi
@Service
public class QueryDataFetcher {

    @GraphQLQuery(name = "getById")
    public Mono<String> getById(@GraphQLArgument(name = "getById") @GraphQLNonNull int id) {
        return Mono
                .fromSupplier(() -> new String())
                .subscribeOn(CoreConfig.gqlScheduler());
    }

}

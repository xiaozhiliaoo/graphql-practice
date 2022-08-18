package org.lili.graphql.config;

import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLRuntime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;


@Configuration
public class CoreConfig {


    @Autowired
    private GraphQLSchema graphQLSchema;


    public static Scheduler gqlScheduler() {
        return Schedulers.boundedElastic();
    }

    @Bean
    public GraphQLRuntime graphQL() {
        GraphQLRuntime.Builder builder = GraphQLRuntime.newGraphQL(graphQLSchema);
        builder.instrumentation(new AccessLogInstrumentation());
        builder.instrumentation(new TracingInstrumentation());
        return builder.build();
    }
}

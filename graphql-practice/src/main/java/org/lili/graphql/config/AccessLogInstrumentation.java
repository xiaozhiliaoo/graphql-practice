package org.lili.graphql.config;

import graphql.ExecutionResult;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.SimpleInstrumentationContext;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;


public class AccessLogInstrumentation extends SimpleInstrumentation {

    @Override
    public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters parameters) {
        long startTime = System.currentTimeMillis();
        return new SimpleInstrumentationContext<ExecutionResult>() {
            @Override
            public void onCompleted(ExecutionResult result, Throwable t) {
                long endTime = System.currentTimeMillis();
                if ("IntrospectionQuery".equals(parameters.getOperation())) {
                    return;
                }
                String operation = parameters.getOperation();
                String query = parameters.getQuery();
                String requester = "";
                try {
                    operation = query.split(" ")[1].split("\\{|\\(")[0];
                    requester = operation.split("_")[0];
                } catch (Exception e) {
                    //log.warn("getOperation query={}, error", query, e);
                }
                //log.info("ACCESS execTime={}, op={}, requester={}, vars={}, errors={}, query={}", endTime - startTime, operation, requester, parameters.getVariables(), result.getErrors(), query);
            }
        };
    }
}

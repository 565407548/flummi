package de.otto.flummi.aggregations;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import static de.otto.flummi.query.QueryBuilders.matchAll;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FilterAggregationBuilderTest {
    @Test
    public void shouldBuildQuery() throws Exception {
        JsonObject result = new FilterAggregationBuilder("filterBuilder")
                .withFilter(matchAll())
                .subAggregation(
                        new TermsBuilder("termsBuilder")
                                .field("bla")
                                .size(10)
                ).build();

        assertThat(result.toString(), is("{\"filter\":{\"match_all\":{}},\"aggregations\":{\"termsBuilder\":{\"terms\":{\"field\":\"bla\",\"size\":10}}}}"));

    }
}
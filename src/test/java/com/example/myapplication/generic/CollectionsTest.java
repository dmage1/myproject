package com.example.myapplication.generic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CollectionsTest {

    private List<String> collection;

    @Before
    public void setUp() {
        collection = Lists.newArrayList("ab", "cd", "ef");

        int expected = 3;
        int actual = collection.size();

        // Hamcrest equals check all statements test the same
        assertThat(actual, equalTo(expected));
        assertThat(actual, is(equalTo(expected)));
        assertThat(actual, is(expected));

        // Hamcrest for not equals check
        assertThat(actual, is(IsNot.not(equalTo(0))));

        // https://www.baeldung.com/hamcrest-collections-arrays
    }

    @Test
    public void checkIf_singleElementIsInACollection_withStrictOrder() {
        assertThat(collection, hasItem("cd"));
        assertThat(collection, not(hasItem("zz")));
    }

    @Test
    public void checkIf_singleElementIsInACollection_withAnyOrder() {
        assertThat(collection, hasItem("cd"));
        assertThat(collection, containsInAnyOrder("cd", "ab", "ef"));
    }

    @Test
    public void checkIf_collectionIsEmpty() {
        List<String> collection = Lists.newArrayList();
        assertThat(collection, empty());
    }

    @Test
    public void checkIf_arrayIsEmpty() {
        String[] array = new String[]{"ab"};
        assertThat(array, not(emptyArray()));
    }

    @Test
    public void checkIf_mapIsEmpty() {
        Map<String, String> collection = Maps.newHashMap();
        assertThat(collection, equalTo(Collections.EMPTY_MAP));
    }

    @Test
    public void checkIf_iterableIsEmpty() {
        Iterable<String> collection = Lists.newArrayList();
        assertThat(collection, emptyIterable());
    }

    @Test
    public void check_sizeOfAnIterable() {
        assertThat(collection, Matchers.iterableWithSize(3));
    }

    @Test
    public void check_conditionOnEveryItem() {
        List<Integer> collection = Lists.newArrayList(15, 20, 25, 30);
        assertThat(collection, everyItem(greaterThan(10)));
    }
}

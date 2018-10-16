package com.jfredricks.filecontenttree.repository.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class FileContentTreeRepositoryImplTest {

    FileContentTreeRepositoryImpl fileContentTreeRepository = new FileContentTreeRepositoryImpl();

    Map<Integer, String> rankMap = new HashMap<>();
    Comparator<String> comparator = (first, second) -> 1;
    Set<String> orderedTreeSet = new TreeSet<>(comparator);
    Map<String, String> designationOrderMap = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        designationOrderMap.put("Barry Allen", "Chief Executive Officer");
        designationOrderMap.put("Clark Kent", "Vice President");
        designationOrderMap.put("Bruce Wayne", "Vice President");
        designationOrderMap.put("Hal Jordan", "Associate Vice President");
    }

    @Test
    public void getOrderedNamesByDesignation() throws Exception {
        assertNotNull(fileContentTreeRepository.getOrderedNamesByDesignation(designationOrderMap));
    }

}
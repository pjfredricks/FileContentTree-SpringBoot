package com.jfredricks.filecontenttree.service.impl;

import com.jfredricks.filecontenttree.repository.FileContentTreeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class FileContentTreeServiceImplTest {

    @Mock
    FileContentTreeRepository fileContentTreeRepository;

    @InjectMocks
    FileContentTreeServiceImpl fileContentTreeService;

    private File file;
    private MockMultipartFile multipartFile;
    private Map<String, String> nameDesignationMap = new HashMap<>();
    private Set<String> orderedSet = new HashSet<>();
    private Set<String> assertionSet = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        file = new File("D:\\Tree Collections\\FileContentTree\\src\\test\\resources\\File_Tree_Input.txt");

        multipartFile = new MockMultipartFile("File_Tree_Input.txt", "D:\\Tree Collections\\FileContentTree\\src\\test\\resources\\File_Tree_Input.txt", null, file.toString().getBytes());
        nameDesignationMap.put("Barry Allen", "Flash");
        nameDesignationMap.put("Clark Kent", "Superman");
        nameDesignationMap.put("Bruce Wayne", "Batman");
        nameDesignationMap.put("Hal Jordan", "Green Lantern");

        orderedSet.addAll(nameDesignationMap.values());
    }

    @Test
    public void convertMultiPartFileToFile() throws Exception {
        assertNotNull(fileContentTreeService.convertMultiPartFileToFile(multipartFile));
        assertEquals(file, fileContentTreeService.convertMultiPartFileToFile(multipartFile));
    }

    @Test
    public void orderByDesignation() throws Exception {
        given(fileContentTreeRepository.getOrderedNamesByDesignation(any())).willReturn(orderedSet);
        assertionSet.addAll(fileContentTreeService.orderByDesignation(file));
        assertTrue(assertionSet.containsAll(nameDesignationMap.values()));
    }

}
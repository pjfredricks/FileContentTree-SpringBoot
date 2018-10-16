package com.jfredricks.filecontenttree.web;

import com.jfredricks.filecontenttree.service.impl.FileContentTreeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FileContentTreeControllerTest {

    @Mock
    FileContentTreeServiceImpl fileContentTreeService;

    @InjectMocks
    FileContentTreeController fileContentTreeController;

    private FileInputStream fileStreamInput;
    private File file = mock(File.class);
    private MultipartFile multipartFile;
    private Set<String> resultSet = new TreeSet<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        fileStreamInput = new FileInputStream("D:\\Tree Collections\\FileContentTree\\src\\test\\resources\\File_Tree_Input.txt");
        multipartFile = new MockMultipartFile("File_Tree_Input.txt", fileStreamInput);

        resultSet.add("Barry Allen");
        resultSet.add("Clark Kent");
        resultSet.add("Bruce Wayne");
        resultSet.add("Hal Jordan");
    }

    @Test
    public void readFileContent() throws Exception {
        given(fileContentTreeService.convertMultiPartFileToFile(any())).willReturn(file);
        given(fileContentTreeService.orderByDesignation(any())).willReturn(resultSet);
        assertEquals(200, fileContentTreeController.readFileContent(multipartFile).getStatusCodeValue());

        Set<String> orderedSet = fileContentTreeController.readFileContent(multipartFile).getBody();
        assertTrue(orderedSet.containsAll(resultSet));
    }

}
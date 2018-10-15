package com.jfredricks.filecontenttree.service;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface FileContentTreeService {

    Set<String> orderByDesignation(File file) throws FileNotFoundException;

    File convertMultiPartFileToFile(MultipartFile file) throws IOException;
}

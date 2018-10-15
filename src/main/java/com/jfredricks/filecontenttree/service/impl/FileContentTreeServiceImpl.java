package com.jfredricks.filecontenttree.service.impl;

import com.jfredricks.filecontenttree.repository.FileContentTreeRepository;
import com.jfredricks.filecontenttree.service.FileContentTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class FileContentTreeServiceImpl implements FileContentTreeService {

    Map<String, String> nameDesignationMap = new HashMap<>();

    @Autowired
    FileContentTreeRepository fileContentTreeRepository;

    @Override
    public File convertMultiPartFileToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(multipartFile.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;
    }

    @Override
    public Set<String> orderByDesignation(File file) throws FileNotFoundException{
        return fileContentTreeRepository.getOrderedNamesByDesignation(readDataFromFile(file));
    }

    private Map<String, String> readDataFromFile(File file) throws FileNotFoundException {
        String line;
        try {
            FileReader filereader = new FileReader((File)file);
            BufferedReader buffer = new BufferedReader(filereader);
            while ((line = buffer.readLine()) != null) {
                String[] split = line.split(",");
                String name = split[0];
                String designation = split[1].trim();
                nameDesignationMap.put(name, designation);
            }
            buffer.close();
        } catch (Exception e) {
            throw new FileNotFoundException("Issue with reading from File. Check the file again.");
        }
        return nameDesignationMap;
    }
}

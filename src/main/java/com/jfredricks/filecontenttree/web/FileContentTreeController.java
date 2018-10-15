package com.jfredricks.filecontenttree.web;

import com.jfredricks.filecontenttree.service.FileContentTreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Set;

@Api
@RestController
@RequestMapping
public class FileContentTreeController {

    @Autowired
    FileContentTreeService fileContentTreeService;

    @ApiOperation(value = "upload a MultiPart File")
    @ApiResponse(code = 400, message = "File may be empty or invalid")
    @PostMapping("api/v1/uploadFile")
    public ResponseEntity<Set<String>> readFileContent(@RequestParam MultipartFile multipartFile) throws IOException {
        File file = fileContentTreeService.convertMultiPartFileToFile(multipartFile);
        return new ResponseEntity<>(fileContentTreeService.orderByDesignation(file) , HttpStatus.OK);
    }
}

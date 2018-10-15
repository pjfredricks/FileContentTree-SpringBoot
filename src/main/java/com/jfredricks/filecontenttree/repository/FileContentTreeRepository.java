package com.jfredricks.filecontenttree.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface FileContentTreeRepository {

    Set<String> getOrderedNamesByDesignation(Map<String, String> fileContent);
}

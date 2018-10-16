package com.jfredricks.filecontenttree.repository.impl;

import com.jfredricks.filecontenttree.repository.FileContentTreeRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FileContentTreeRepositoryImpl implements FileContentTreeRepository {

    Map<Integer, String> rankMap = new HashMap<>();
    Comparator<String> comparator = (first, second) -> 1;
    Set<String> orderedTreeSet = new TreeSet<>(comparator);

    public void setRankMap() {
        rankMap.put(1, "Chief Executive Officer");
        rankMap.put(2, "Vice President");
        rankMap.put(3, "Associate Vice President");
        rankMap.put(4, "Senior Manager - Projects");
        rankMap.put(5, "Manager - Projects");
        rankMap.put(6, "Architect");
        rankMap.put(7, "Associate");

//        for (Map.Entry<Integer, String> m : rankMap.entrySet()) {
//            for (Map.Entry<String, String> m2 : designationOrderMap.entrySet()) {
//                if (m.getValue().equals(m2.getValue())) {
//                    orderedTreeSet.add(m2.getKey());
//                } else
//                    continue;
//            }
//        }
    }

    @Override
    public Set<String> getOrderedNamesByDesignation(Map<String, String> designationOrderMap) {
        setRankMap();
        orderedTreeSet.clear();
        rankMap.entrySet()
                .stream()
                .forEach(designationRank -> designationOrderMap
                        .entrySet()
                        .stream()
                        .forEach(nameDesignation -> {
                            if (designationRank.getValue().equals(nameDesignation.getValue())) {

                                orderedTreeSet.add(nameDesignation.getKey());
                            }
                        }));
        return orderedTreeSet;
    }
}

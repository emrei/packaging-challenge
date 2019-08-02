package com.yemre.dao;

import java.util.List;

import com.yemre.exception.APIException;
import com.yemre.model.Case;

/**
 * InputDAO class for fetching Case objects
 * 
 * @author YunusEmre
 *
 */
public interface InputDAO {
    /**
     * fetch case list
     * 
     * @return
     * @throws APIException
     */
    public List<Case> getCaseList() throws APIException;
}

package com.yemre.service;

import java.util.List;

import com.yemre.exception.APIException;
import com.yemre.model.Case;
/**
 * Input Service for gathering case inputs
 * @author YunusEmre
 *
 */
public interface InputService {
    /**
     * returns case list
     * @return
     * @throws APIException
     */
    public List<Case> getCaseList() throws APIException;
}

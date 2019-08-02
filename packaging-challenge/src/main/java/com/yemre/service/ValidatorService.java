package com.yemre.service;

import com.yemre.exception.APIException;
import com.yemre.model.Case;

/**
 * Validator class for Case object
 * @author YunusEmre
 *
 */
public interface ValidatorService {
    /**
     * validate input case, if it is not valid throws APIException 
     * @param inputCase
     * @throws APIException
     */
    public void validate(Case inputCase) throws APIException;
}

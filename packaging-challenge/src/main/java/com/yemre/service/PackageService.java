package com.yemre.service;

import com.yemre.exception.APIException;
import com.yemre.model.Case;

/**
 * Package Service to run pack-algorithm
 * 
 * @author YunusEmre
 *
 */
public interface PackageService {
    /**
     * Runs algorithm for given case. It maximize cost while minimizing weight of
     * things. Generate all combinations of thing list and then select best
     * solution. Complexity is high because it uses brute force algorithm.
     * Complexity is 2^n. If maximum thing count is 15 then is is quite reasonable
     * to use this algorithm
     * 
     * @param inputCase
     * @return
     * @throws APIException
     */
    public Case pack(Case inputCase) throws APIException;
}

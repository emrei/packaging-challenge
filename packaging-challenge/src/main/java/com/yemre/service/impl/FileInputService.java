package com.yemre.service.impl;

import java.util.List;

import com.yemre.dao.InputDAO;
import com.yemre.exception.APIException;
import com.yemre.model.Case;
import com.yemre.service.InputService;

/**
 * InputService implementation class
 * 
 * @author YunusEmre
 *
 */
public class FileInputService implements InputService {

    InputDAO fileInputDAO;

    public FileInputService(InputDAO fileInputDAO) {
	this.fileInputDAO = fileInputDAO;
    }

    @Override
    public List<Case> getCaseList() throws APIException {
	return fileInputDAO.getCaseList();

    }

}

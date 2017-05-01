package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.StatusEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class Status extends AbstractDao<StatusEntity> {
    private final Logger logger = Logger.getLogger(getClass());

    Status() {
        super(StatusEntity.class);
    }

    public List<StatusEntity> listAll() {
        logger.info("Reading all from named query 'StatusEntity.findAll'");
        return listAll("StatusEntity.findAll");
    }

    public List<StatusEntity> listRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'StatusEntity.findAll'");
        return listAllRange("StatusEntity.findAll", pageCount, pageSize);
    }
}

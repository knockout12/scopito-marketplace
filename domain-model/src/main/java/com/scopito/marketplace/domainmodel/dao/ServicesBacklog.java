package com.scopito.marketplace.domainmodel.dao;

import com.scopito.marketplace.domainmodel.model.ServicesBacklogEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.RequestScoped;
import java.util.List;
@RequestScoped
public class ServicesBacklog extends AbstractDao<ServicesBacklogEntity>
{
    private final Logger logger = Logger.getLogger(getClass());

    ServicesBacklog() {
        super(ServicesBacklogEntity.class);

    }

    public List<ServicesBacklogEntity> listAll() {
        logger.info("Reading all from named query 'ServicesBacklog.findAll'");
        return listAll("ServicesBacklog.findAll");
    }


    public List<ServicesBacklogEntity> listRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'ServicesBacklog.findAll'");
        return listAllRange("ServicesBacklog.findAll", pageCount, pageSize);
    }


}



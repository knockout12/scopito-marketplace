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

    /**
     * Fetch and bring list of services from the database.
     * the Method is called from the controller, ejb - controller, ServicesBean
     * @return list of All the Services offered in the backlog
     */
    public List<ServicesBacklogEntity> getBacklog() {
        logger.info("Reading all from named query 'ServicesBacklog.findAll'");
        return listAll("ServicesBacklog.findAll");
    }

    /**
     * This method does the same as getBacklog but integrate pagenation capabilities, divide list to chunks)
     * @param pageCount the ordinary number of the page.
     * @param pageSize number of items per page.
     * @return list (in the specified size) of Services offered in the backlog
     */
    public List<ServicesBacklogEntity> getBacklogListRange(int pageCount, int pageSize) {
        logger.info("Reading range from named query 'ServicesBacklog.findAll'");
        return listAllRange("ServicesBacklog.findAll", pageCount, pageSize);
    }

}



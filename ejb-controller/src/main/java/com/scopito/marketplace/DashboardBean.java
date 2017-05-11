package com.scopito.marketplace;

import com.scopito.marketplace.domainmodel.dao.Status;
import com.scopito.marketplace.domainmodel.model.StatusEntity;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class DashboardBean {
    private final Logger logger = Logger.getLogger(getClass());

    @Inject
    private Status status;

    public Long countAll() {
        return status.count();
    }

    public List<StatusEntity> list(int pageCount, int pageSize) {
        logger.info(String.format("List rage from page '%d' with max size '%d'", pageCount, pageSize));
        return status.listRange(pageCount, pageSize);
    }

    public boolean create(String name) {
        if(name == null || name.isEmpty()) {
            return false;
        }

        final StatusEntity statusEntity = new StatusEntity();
        statusEntity.setName(name);

        return status.create(statusEntity) != null;
    }
}

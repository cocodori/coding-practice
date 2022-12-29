package org.example.ch02.domain.specification;

import org.example.ch02.domain.entity.Router;
import org.example.ch02.domain.specification.shared.AbstractSpecification;

public class NetworkAmountSpecification extends AbstractSpecification<Router> {

    public static final int MAXIMUM_ALLOWED_NETWORKS = 6;

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.retrieveNetworks().size() <= MAXIMUM_ALLOWED_NETWORKS;
    }

}

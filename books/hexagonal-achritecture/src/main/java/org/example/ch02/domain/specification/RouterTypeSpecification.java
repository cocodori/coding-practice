package org.example.ch02.domain.specification;

import org.example.ch01.domain.RouterType;
import org.example.ch02.domain.entity.Router;
import org.example.ch02.domain.specification.shared.AbstractSpecification;

public class RouterTypeSpecification extends AbstractSpecification<Router> {
    @Override
    public boolean isSatisfiedBy(Router router) {
        return router.getRouterType().equals(RouterType.EDGE) || router.getRouterType().equals(RouterType.CORE);
    }
}

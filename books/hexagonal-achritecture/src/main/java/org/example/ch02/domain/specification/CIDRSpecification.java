package org.example.ch02.domain.specification;

import org.example.ch02.domain.specification.shared.AbstractSpecification;

public class CIDRSpecification extends AbstractSpecification<Integer> {

    public static final int MINIMUM_ALLOWED_CIDR = 0;

    @Override
    public boolean isSatisfiedBy(Integer cidr) {
        return cidr > MINIMUM_ALLOWED_CIDR;
    }
}

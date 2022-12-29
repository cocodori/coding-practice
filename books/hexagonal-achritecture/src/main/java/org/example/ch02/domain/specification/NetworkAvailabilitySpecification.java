package org.example.ch02.domain.specification;

import org.example.ch02.domain.vo.IP;
import org.example.ch02.domain.vo.Network;
import org.example.ch02.domain.entity.Router;
import org.example.ch02.domain.specification.shared.AbstractSpecification;

public class NetworkAvailabilitySpecification extends AbstractSpecification<Router> {

    private IP address;
    private String name;
    private int cidr;

    public NetworkAvailabilitySpecification(IP address, String name, int cidr) {
        this.address = address;
        this.name = name;
        this.cidr = cidr;
    }

    @Override
    public boolean isSatisfiedBy(Router router) {
        return router != null && isNetworkAvailable(router);
    }

    private boolean isNetworkAvailable(Router router) {
        var availability = true;
        for (Network network: router.retrieveNetworks()) {
            if (network.getAddress().equals(address) && network.getName().equals(name) && network.getCidr() == cidr) {
                availability = false;
                break;
            }
        }

        return availability;
    }
}

package org.example.ch02.domain.service;

import org.example.ch02.domain.entity.Router;
import org.example.ch02.domain.specification.CIDRSpecification;
import org.example.ch02.domain.specification.NetworkAmountSpecification;
import org.example.ch02.domain.specification.NetworkAvailabilitySpecification;
import org.example.ch02.domain.specification.RouterTypeSpecification;
import org.example.ch02.domain.vo.IP;
import org.example.ch02.domain.vo.Network;

public class NetworkOperation {


    public void createNewNetwork2(Router router, IP address, String name, int cidr) {
        var availabilitySpec = new NetworkAvailabilitySpecification(address, name, cidr);
        var cidrSpec = new CIDRSpecification();
        var routerTypeSpec = new RouterTypeSpecification();
        var amountSpec = new NetworkAmountSpecification();

        if (cidrSpec.isSatisfiedBy(cidr))
            throw new IllegalArgumentException("CIDR is below " + CIDRSpecification.MINIMUM_ALLOWED_CIDR);
        if (availabilitySpec.isSatisfiedBy(router))
            throw new IllegalArgumentException("Address already exist");
        if (amountSpec.and(routerTypeSpec).isSatisfiedBy(router)) {
            Network network = router.createNetwork(address, name, cidr);
            router.addNetworkToSwitch(network);
        }
    }

    private final int MINIMUM_ALLOWED_CIDR = 8;

    public void createNetwork(Router router, IP address, String name, int cidr) {
        if (cidr < MINIMUM_ALLOWED_CIDR)
            throw new IllegalArgumentException("CIDR is below " + MINIMUM_ALLOWED_CIDR);

        if (isNetworkAvailable(router, address, cidr))
            throw new IllegalArgumentException("Address already exist");

        Network network = router.createNetwork(address, name, cidr);
        router.addNetworkToSwitch(network);
    }

    private boolean isNetworkAvailable(Router router, IP address, int cidr) {
        var availability = true;

        for (Network network : router.retrieveNetworks()) {
            if (network.getAddress().equals(address) && network.getCidr() == cidr) {
                availability = false;
                break;
            }
        }

        return availability;
    }
}
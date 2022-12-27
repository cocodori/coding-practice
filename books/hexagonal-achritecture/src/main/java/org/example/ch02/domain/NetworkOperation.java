package org.example.ch02.domain;

public class NetworkOperation {
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
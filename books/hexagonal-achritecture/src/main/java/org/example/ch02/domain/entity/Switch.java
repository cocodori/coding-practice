package org.example.ch02.domain.entity;

import org.example.ch02.domain.vo.IP;
import org.example.ch02.domain.vo.Network;
import org.example.ch02.domain.vo.SwitchId;
import org.example.ch02.domain.vo.SwitchType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Switch {
    private SwitchType switchType;
    private SwitchId switchId;
    private List<Network> networks;
    private IP address;

    public Switch(SwitchType type, SwitchId switchId, List<Network> networks, IP address) {
        this.switchType = type;
        this.switchId = switchId;
        this.networks = networks;
        this.address = address;
    }

    public Switch addNetwork(Network network) {
        var networks = new ArrayList<>(Arrays.asList(network));
        networks.add(network);
        return new Switch(this.switchType, this.switchId, this.networks, this.address);
    }

    public List<Network> getNetworks() {
        return this.networks;
    }
}

package com.omar.topology.models;

import java.util.ArrayList;

public class Topology {

    private String id;
    private ArrayList<TopologyComponent> components;

    public Topology(String id, ArrayList<TopologyComponent> components) {
        this.id = id;
        this.components = components;
    }

    public String getId() {
        return id;
    }

    public ArrayList<TopologyComponent> getComponents() {
        return components;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setComponents(ArrayList<TopologyComponent> components) {
        this.components = components;
    }
}

package com.omar.topology.models;

import java.util.HashMap;
import java.util.List;

public class TopologyComponent {

    private String type;
    private String id;

    private HashMap<String, String> netList;

    public TopologyComponent(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getNetList() {
        return netList;
    }

    public void setNetList(HashMap<String, String> netList) {
        this.netList = netList;
    }
}

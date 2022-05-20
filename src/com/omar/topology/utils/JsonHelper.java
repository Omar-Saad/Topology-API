package com.omar.topology.utils;

import com.google.gson.Gson;
import com.omar.topology.models.Topology;
import com.omar.topology.models.TopologyComponent;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonHelper {
    private ArrayList<Topology> topologies = new ArrayList<>();

    private  Reader readFile(String fileName) {
        Reader reader = null;
        try {
            // create a reader
            reader = Files.newBufferedReader(Paths.get(fileName));
            // close reader
            reader.close();

        } catch (Exception ex) {
            System.out.println("Error in reading file");
        }
        return reader;

    }
public  Topology readTopologyFromJson(String fileName){
        Topology topology = null;
        try {
            Reader fileData = readFile(fileName);
            // create Gson instance
            Gson gson = new Gson();

            // convert JSON string to User object
            topology = gson.fromJson(fileData,Topology.class);
            topologies.add(topology);


        } catch (Exception ex) {
            System.out.println("Error in parding json file");
        }
        return topology;
    }

    public void queryTopologies() {
        if(topologies.isEmpty()){
            System.out.println("No Topologies Found");
        }
        else {
            System.out.println("Topologies In memory : ");
            for (Topology topology1 : topologies) {
                System.out.println(topology1.getId());
            }
        }

    }

    public void deleteTopology(String topologyId){
        for (Topology topology1 : topologies) {
            if(topology1.getId().equals(topologyId)){
                topologies.remove(topology1);
                System.out.println("Topology Deleted");
                break;
            }
        }
    }

    public void addTopology(Topology topology){
        topologies.add(topology);
        System.out.println("Topology Added");
    }

    public void queryDevicesInTopology(String topologyId){
        for (Topology topology : topologies) {
            if(topology.getId().equals(topologyId)){
                System.out.println("Devices in Topology : ");
                for (TopologyComponent  topologyComponent : topology.getComponents()) {
                    System.out.println(topologyComponent.getId());
                }
                break;
            }
        }
    }

    public void queryDeviceWithNetListNodeId(String topologyId,String nodeId){
        for (Topology topology : topologies) {
            if(topology.getId().equals(topologyId)){
                for (TopologyComponent  topologyComponent : topology.getComponents()) {
                    if(topologyComponent.getNetList().get(nodeId)!=null){
                        System.out.println("Device Details : ");
                        System.out.println("ID : "+topologyComponent.getId());
                        System.out.println("Type : "+topologyComponent.getType());
                        break;
                    }
                }
                break;
            }
        }
    }

    public void writeTopologyToJsonFile(String topId , String fileName){
        for(Topology topology : topologies){
            if(topology.getId().equals(topId)){
                Gson gson = new Gson();
                String json = gson.toJson(topology);
                try {
                    try {
                        Files.write(Paths.get(fileName), json.getBytes());
                    } catch (Exception ex) {
                        System.out.println("Error in writing to file");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }

    }

//    public void addTopologyTopologyToJson(Topology topology, String fileName){
//        try {
//            // create Gson instance
//            Gson gson = new Gson();
//
//            // convert User object to JSON string
//            String json = gson.toJson(topology);
//
//            // write JSON string to file
//            Files.write(Paths.get(fileName), json.getBytes());
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }


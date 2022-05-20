package com.omar.topology;

import com.omar.topology.controller.TopologyController;
import com.omar.topology.models.Topology;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Welcome to Topology Api");
        System.out.println("Options : ");
        System.out.println("1. Read Topology From Json File");
        System.out.println("2. Query about Topologies");
        System.out.println("3. Delete Topology");
        System.out.println("4. Query about devices in topology");
        System.out.println("5. Query about which devices are connected to a given netlist node in\n" +
                "a given topology.");
        System.out.println("6. Write a given topology from the memory to a JSON file.");

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Enter Your choice :  ");
        int choice= sc.nextInt();
        TopologyController topologyController = new TopologyController();

        switch (choice) {
            case 1:
                System.out.println("Enter the file name : ");
                String fileName = sc.next();
                topologyController = new TopologyController();
                Topology topology = topologyController.readTopologyFromJson(fileName);
                System.out.println("Reading Topology From Json File Done...");
                break;
            case 2:
                topologyController.queryTopologies();
                break;
            case 3:
                System.out.println("Enter topology  ID : ");
                String topID = sc.next();

                topologyController.deleteTopology(topID);
                System.out.println("Deleting Topology From Memory  Done...");
                break;
            case 4:
                System.out.println("Enter topology  ID : ");
                String topID1 = sc.next();
                topologyController.queryDevicesInTopology(topID1);
                System.out.println("Querying Topology Devices Done...");
                break;
            case 5:
                System.out.println("Enter topology  ID : ");
                String topID2 = sc.next();
                System.out.println("Enter netlist node name : ");
                String nodeName = sc.next();
                topologyController.queryDeviceWithNetListNodeId(topID2, nodeName);
                System.out.println("Querying Topology Devices Connected to Node Done...");
                break;
            case 6:
                System.out.println("Enter topology  ID : ");
                String topID3 = sc.next();
                System.out.println("Enter json file name : ");
                String fileName1 = sc.next();
                topologyController.writeTopologyToJsonFile(topID3 , fileName1);
                System.out.println("Writing Topology To Json File Done...");
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }

    }
}

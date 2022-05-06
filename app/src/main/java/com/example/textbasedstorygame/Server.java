package com.example.textbasedstorygame;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    private Scanner csvFile;
    private ArrayList<Node> nodes;

    public Server(InputStream filePath) throws FileNotFoundException {
        csvFile = new Scanner(filePath);
        nodes = new ArrayList<Node>();

        while(hasAnotherLine()){
            //Get a line from the file
            String line = getLine();

            //Passes 'line' into the splitLine method and makes lineArray equal to the result
            String[] lineArray = splitLine(line);

            //Convert data
            int nodeID = Integer.parseInt(lineArray[0]);
            int decisionOneID = Integer.parseInt(lineArray[1]);
            int decisionTwoID = Integer.parseInt(lineArray[2]);
            String nodeText = lineArray[3];
            String decisionOneText = lineArray[4];
            String decisionTwoText = lineArray[5];

            //Build a Node object
            Node n = new Node(nodeID, decisionOneID, decisionTwoID, nodeText, decisionOneText, decisionTwoText);

            //Add my Node to my ArrayList / Array
            nodes.add(n);
        }
    }
    
    //Get a line from the file
    public String getLine() {
        return csvFile.nextLine();
    }
    
    //Close the file
    public void close() {
        csvFile.close();
    }
    
    //Check if there is another line present in the file
    public boolean hasAnotherLine() {
        return csvFile.hasNext();
    }

    //A private method which is passed a line, splits it up by every ',' and puts the split segments
    //into an Array
    private String[] splitLine(String line) {
        return line.split(",");
    }

    //The toString method loops round and grabs all the nodes
    public String toString() {
        String string = "";
        for (Node node : nodes){
            string += node.toString() + "\n";
        }
        return string;
    }

    //Gets the Node based on the ID passed to it - Array indexing starts at 0, so Node 5, for
    //example, will be index 4; hence the 'nodeID - 1'
    public Node getNode(int nodeID) {
        return (nodes.get(nodeID - 1));
    }

    
    
}

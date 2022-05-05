package com.example.textbasedstorygame;

import android.widget.Button;
import android.widget.TextView;

public class Node {
    
    private int nodeID;
    private int decisionOneID;
    private int decisionTwoID;
    private String nodeText;
    private String decisionOneText;
    private String decisionTwoText;


    //Method to apply current Node's values to buttons / text field
    public void setNewValues(Node currentNode, MainActivity MainActivity) {
        TextView tv = (TextView) MainActivity.findViewById(R.id.about_title);
        tv.setText(currentNode.getNodeText());
        Button buttonOne = (android.widget.Button) MainActivity.findViewById(R.id.buttonOne);
        buttonOne.setText(currentNode.getDecisionOneText());
        Button buttonTwo = (android.widget.Button) MainActivity.findViewById(R.id.buttonTwo);
        buttonTwo.setText(currentNode.getDecisionTwoText());
    }


    //Node Constructor (Blank)
    public Node() {
    }


    //Node Constructor
    public Node(int nodeID, int decisionOneID, int decisionTwoID, String nodeText, String decisionOneText,
            String decisionTwoText) {
        this.nodeID = nodeID;
        this.decisionOneID = decisionOneID;
        this.decisionTwoID = decisionTwoID;
        this.nodeText = nodeText;
        this.decisionOneText = decisionOneText;
        this.decisionTwoText = decisionTwoText;
    }


    //Getters & Setters
    public int getNodeID() {
        return nodeID;
    }

    public void setNodeID(int nodeID) {
        this.nodeID = nodeID;
    }

    public int getDecisionOneID() {
        return decisionOneID;
    }

    public void setDecisionOneID(int decisionOneID) {
        this.decisionOneID = decisionOneID;
    }

    public int getDecisionTwoID() {
        return decisionTwoID;
    }

    public void setDecisionTwoID(int decisionTwoID) {
        this.decisionTwoID = decisionTwoID;
    }

    public String getNodeText() {
        return nodeText;
    }

    public void setNodeText(String nodeText) {
        this.nodeText = nodeText;
    }

    public String getDecisionOneText() {
        return decisionOneText;
    }

    public void setDecisionOneText(String decisionOneText) {
        this.decisionOneText = decisionOneText;
    }

    public String getDecisionTwoText() {
        return decisionTwoText;
    }

    public void setDecisionTwoText(String decisionTwoText) {
        this.decisionTwoText = decisionTwoText;
    }

}

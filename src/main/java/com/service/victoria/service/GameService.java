package com.service.victoria.service;

import com.service.victoria.beans.GameResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class GameService {

    public static Logger logger = Logger.getLogger(GameService.class.getName());

    static class Node {
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            this.next= null;
        }
    }

    public static GameResponse getLastChildPosition(int noOfChildren, int counter){
        logger.info("In getLastChildPosition : input values are noOfChildren : " + noOfChildren  + " counter : " + counter);
        Node headNode = createCircularLinkedList(noOfChildren);
        int loopCounter;
        List<Integer> removedChildList = new ArrayList<>();
        GameResponse response = new GameResponse();
        while(headNode.next != headNode){
            loopCounter = 1;
            while(loopCounter<counter-1)
            {
                loopCounter++;
                headNode = headNode.next;
            }
            removedChildList.add(headNode.next.data);
            headNode.next = headNode.next.next;
            headNode = headNode.next;
        }
        logger.info("winner is child at position : " + headNode.data);
        response.setRemovedChildList(removedChildList);
        response.setWinningChildId(headNode.data);
        return response;
    }

    public static Node createCircularLinkedList(int noOfChildren) {
        int position = 1;
        Node head = new Node(position);
        head.next = head;
        Node tail = head;

        Node currentNode;
        while(position++ < noOfChildren){
            currentNode = new Node(position);
            currentNode.next = head;
            tail.next = currentNode;
            tail = currentNode;
        }
        return head;
    }
}

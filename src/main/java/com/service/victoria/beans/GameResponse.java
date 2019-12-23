package com.service.victoria.beans;

import java.util.List;

public class GameResponse {

    public List<Integer> getRemovedChildList() {
        return removedChildList;
    }

    public void setRemovedChildList(List<Integer> removedChildList) {
        this.removedChildList = removedChildList;
    }

    public int getWinningChildId() {
        return winningChildId;
    }

    public void setWinningChildId(int winningChildId) {
        this.winningChildId = winningChildId;
    }

    List<Integer> removedChildList;
    int winningChildId;
}

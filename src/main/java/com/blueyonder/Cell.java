package com.blueyonder;

public class Cell {
    private Object data;

    public Cell() {
        data = new Object();
    }

    public Cell(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

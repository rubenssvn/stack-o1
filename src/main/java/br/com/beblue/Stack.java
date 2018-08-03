package br.com.beblue;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> data;
    private List<Integer> minIndexes;

    public Stack() {
        data = new ArrayList<>();
        minIndexes = new ArrayList<>();
    }

    public void push(Integer value) {
        data.add(value);
        boolean isLower = false;
        try {
            Integer lastMinIndex = getLastItem(minIndexes);
            isLower = value <= data.get(lastMinIndex);
        } catch (EmptyStackException e) {
            isLower = true;
        }

        if (isLower) {
            Integer minIndex = data.size() - 1;
            minIndexes.add(minIndex);
        }
    }

    public Integer pop() {
        Integer popItem = getLastItem(data);
        Integer lastMinIndex = getLastItem(minIndexes);
        if (popItem == data.get(lastMinIndex)) {
            removeLastItem(minIndexes);
        }
        removeLastItem(data);
        return popItem;
    }
    
    public Integer min() {
        Integer lastMinIndex = getLastItem(minIndexes);
        return data.get(lastMinIndex);    
    }

    private void removeLastItem(List<Integer> list) {
        list.remove(list.size() - 1);
    }

    private Integer getLastItem(List<Integer> list) {
        Integer index = list.size() - 1;
        if (index >= 0) {
            return list.get(list.size() - 1);
        }
        throw new EmptyStackException();
    }
}
package Practise2025.CompanyC;

import java.util.*;


interface Iterator{
	public int next();
	public boolean hasNext();
}

class RangeIterator implements Iterator{
	
	int start;
	int end;
	int step;
	int curr;
	
	public RangeIterator(int start, int end, int step) {
		this.start = start;
		this.end = end;
		this.step = step;
		this.curr = 0;
	}
	
	public int next() {
		int val = curr;
		curr += step;
		return val;
	}
	
	public boolean hasNext() {
		if(curr <= end) {
			return true;
		}
		return false;
	}
}

class ListIterator implements Iterator{
	
	List<Integer> list;
	int currIndex = 0;
	
	public ListIterator(List<Integer> list) {
		this.list = list;
	}
	
	public int next() {
		currIndex++;
		return list.get(currIndex -1);
	}
	
	public boolean hasNext() {
		return currIndex < list.size();
	}	
}

class ZigzagIterator implements Iterator{

    List<Iterator> listOfIterators;
    Queue<Iterator> q; // which list and it's index

    public ZigzagIterator(List<Iterator> listOfIterators) {
        this.listOfIterators = listOfIterators;
        q = new LinkedList<>();
        for(Iterator it: listOfIterators) {
        	if(it.hasNext()) {
        		q.add(it);
        	}
        }
    }

    public int next() {
    	Iterator next = q.poll();
        int val = next.next();
        if(next.hasNext()) {
        	q.add(next);
        }
        return val;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

public class IteratorMainClass {
	public static void main(String[] args) {
		Iterator rangeIt = new RangeIterator(0, 10, 2);
		Iterator listIt = new ListIterator(List.of(0, 1, 2, 3, 4, 5));
		List<Iterator> list = List.of(rangeIt, listIt);
		Iterator zigZagIt = new ZigzagIterator(list);
		while(zigZagIt.hasNext()) {
			System.out.println(zigZagIt.next());
		}
	}
}


















































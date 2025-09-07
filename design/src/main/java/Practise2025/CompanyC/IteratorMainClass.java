package Practise2025.CompanyC;

import java.util.*;


/*
Level 1:
Write an alternate iterator for list of lists. Similar to ZigZag Iterator on leetcode but you can have not just 2 but 'n' lists within the list;
https://leetcode.com/problems/zigzag-iterator/description/

Example :
lists = [[0, 1, 2], [], [3, 4], [5]]
output should be 0, 3, 5, 1, 4, 2

Level 2:
Write a range iterator. Should support negative step as well.
Example :
start = 0
end = 10
step = 2
output should be [0, 2, 4, 6, 8, 10]

Level 3:
Write a basic list iterator
list = [0, 1, 2, 3, 4, 5]
output should be 0, 1, 2, 3, 4, 5

Level 4:
Modify the class written in level1 to take list of iterator objects instead of lists and print the numbers in alternate fashion. The iterators list can contain both range iterator and list iterator.
 */


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


















































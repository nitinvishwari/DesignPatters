package Practise2025.CompanyC;

import java.util.*;

/*
You will be given a list of transactions. You need to write a generic search api to filter on a combination of specific fields and values
Example :
transactions = [
{id: 1, time: 1, userId: 1, amount: 10},
{id: 2, time: 2, userId: 3, amount: 10},
{id: 3, time: 3, userId: 4, amount: 11},
{id: 4, time: 4, userId: 2, amount: 12},
]
Filters should support operations like "=", ">", "<" etc
The question is open ended. You need to decide how the input should look like.

Follow up :
Explain pagination and why we need it?
What are some of the techniques used for pagination?
How do you choose a cursor id column when using cursor based pagination?
Enhance your code to support cursor based pagination.
 */

class Transaction{
	int id;
	int time;
	int userId;
	int amount;
	public Transaction(int id, int time, int userId, int amount) {
		this.id = id;
		this.time = time;
		this.userId = userId;
		this.amount = amount;
	}
	public Object getValue(String field) {
		if(field.equals("id")) {
			return (Integer) id;
		}
		else if(field.equals("time")) {
			return (Integer) time;
		}
		else if(field.equals("userId")) {
			return (Integer) userId;
		}
		else if(field.equals("amount")) {
			return (Integer) amount;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ", time: " + time + ", userId: " + userId + ", amount: " + amount;
	}
}


interface Operator{
	public boolean value(Transaction t, String field, int compareVal);
}

class GreaterOp implements Operator{
	public boolean value(Transaction t, String field, int compareVal) {
		Object val = t.getValue(field);
		if(val != null && (int) val > compareVal) {
			return true;
		}
		return false;
	}
}

class LessOp implements Operator{
	public boolean value(Transaction t, String field, int compareVal) {
		Object val = t.getValue(field);
		if(val != null && (int) val < compareVal) {
			return true;
		}
		return false;
	}
}

class EqualOp implements Operator{
	public boolean value(Transaction t, String field, int compareVal) {
		Object val = t.getValue(field);
		if(val != null && (int) val == compareVal) {
			return true;
		}
		return false;
	}
}

class TransactionManager{
	List<Transaction> listOfTransactions;
	HashMap<Integer, Integer> transactionMap;
	
	public TransactionManager(List<Transaction> listOfTransactions) {
		this.listOfTransactions = listOfTransactions;
		transactionMap = new HashMap<>();
		int index = 0;
		for(Transaction t: listOfTransactions) {
			transactionMap.put(t.id, index);
			index++;
		}
	}
	
	public List<Transaction> offsetFilter(Operator op, String field, int val, int pageSize, int offSet){
		List<Transaction> filterTransactions = new ArrayList<>();
		int offsetCount = 0;
		int count = 0;
		for(Transaction t: listOfTransactions) {
			if(op.value(t, field, val)) {
				if(offSet > offsetCount) {
					offsetCount++;
					continue;
				}
				if(count < pageSize) {
					count++;
					filterTransactions.add(t);
				}
				else {
					break;
				}
			}
		}
		return filterTransactions;
	}
	
	public List<Transaction> cursorFilter(Operator op, String field, int val, int pageSize, Integer cursorTId){
		int index = (cursorTId == null) ? 0: transactionMap.get(cursorTId);
		List<Transaction> filterTransactions = new ArrayList<>();
		int count = 0;
		for(int i=index+1; i<listOfTransactions.size(); i++) {
			Transaction t = listOfTransactions.get(i);
			if(count < pageSize) {
				if(op.value(t, field, val)) {
					count++;
					filterTransactions.add(t);
				}
			}
			else {
				break;
			}
		}
		return filterTransactions;
	}
}

public class TransactionMainClass {
	public static void main(String[] args) {
		List<Transaction> list = new ArrayList<>();
		Transaction t1 = new Transaction(1, 1, 1, 10);
		list.add(t1);
		Transaction t2 = new Transaction(2, 5, 2, 15);
		list.add(t2);
		Transaction t3 = new Transaction(3, 10, 1, 12);
		list.add(t3);
		Transaction t4 = new Transaction(4, 10, 3, 24);
		list.add(t4);
		TransactionManager tm = new TransactionManager(list);
		List<Transaction> result = tm.offsetFilter(new GreaterOp(), "amount", 11, 2, 2);
//		for(Transaction t: result)
//			System.out.println(t);
		
		result = tm.cursorFilter(new GreaterOp(), "amount", 11, 2, null);
//		for(Transaction t: result)
//			System.out.println(t);
		
		result = tm.cursorFilter(new GreaterOp(), "amount", 11, 2, result.get(result.size() -1).id);
		for(Transaction t: result)
			System.out.println(t);
	}
}






























































































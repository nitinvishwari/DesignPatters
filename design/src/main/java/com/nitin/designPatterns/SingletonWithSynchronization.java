package com.nitin.designPatterns;

class KingMaker{
	
	private static KingMaker kingMaker;
	
	private KingMaker() {
	}
	
	public static KingMaker getInstance() {
		if(kingMaker == null) {
			synchronized(KingMaker.class) {
				if(kingMaker == null) {
					kingMaker = new KingMaker();
				}
			}
		}
		return kingMaker;
	}
}

public class SingletonWithSynchronization {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			KingMaker kingMaker = KingMaker.getInstance();
		});
	}
}

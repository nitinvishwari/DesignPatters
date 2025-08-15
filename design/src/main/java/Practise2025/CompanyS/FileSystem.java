package Practise2025.CompanyS;

import java.util.*;

class Node{
	String name;
	boolean isFile;
	String content;
	HashMap<String, Node> children;
	
	public Node() {
		this(null, false, null);
	}
	public Node(String name) {
		this(name, false, null);
	}
	public Node(String name, boolean isFile, String content) {
		this.name = name;
		this.isFile = isFile;
		this.content = content;
		this.children = new HashMap<>();
	}
}

class FileSystemMain {
	
	Node root;
	
	public FileSystemMain() {
		root = new Node();
	}
	
	// seprate implementation to optimize 
	public String[] splittedPath(String path) {
		if(path == null || path.isEmpty()) {
			return null;
		}
		String[] splittedString = path.split("/");
		return splittedString;
	}

	public void addFolder(String path) {
		String[] nameArray = splittedPath(path);
		if(nameArray == null) {
			return;
		}
		Node curr = root;
		for(String nextNodeName: nameArray) {
			if(curr.children.containsKey(nextNodeName)) {
				curr = curr.children.get(nextNodeName);
			}
			else {
				Node newNode = new Node(nextNodeName);
				curr.children.put(nextNodeName, newNode);
			}
		}
	}
	
	public boolean removeFolder(String path) {
		String[] nameArray = splittedPath(path);
		if(nameArray == null) {
			return false;
		}
		Node curr = root;
		int index = 1;
		for(String nextNodeName: nameArray) {
			if(curr.children.containsKey(nextNodeName)) {
				if(index == nameArray.length) {
					curr.children.remove(nextNodeName);
					return true;
				}
				curr = curr.children.get(nextNodeName);
			}
			else {
				return false;
			}
			index++;
		}
		return false;
	}
	
	public void addFile(String path, String content) {
		
	}
	
	public void move(String source, String destination) {
		
	}
	
	public List<String> allSubPaths(String path){
		List<String> listOfPaths = new ArrayList<>();
		
		return listOfPaths;
	}
}



/*
add_folder(path)


remove_folder(path)


add_file(path, content)


move(source, destination)


list(path)


how's the path going to look like 
/file_name/file.txt

a/b/c.txt
*/
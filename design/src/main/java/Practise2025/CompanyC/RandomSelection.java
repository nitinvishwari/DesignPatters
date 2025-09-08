package Practise2025.CompanyC;

import java.util.*;

/*
Part 1: You're given a list of values of object property.
Example: The object is a tree.
Length:[ Short, medium, tall]
Leaf colour: [Green, yellow, red]
Like this, you have multiple properties.
Now create a list of random objects by randomly selecting each property's value.
Part 2: Generate unique objects in part 1.
Part 3: Add a rarity option to the properties. For example, if the 'Tall' property is 'rare' then there should be only a few tall trees when you create random trees in part 2.



I don't remember the exact question but it was related to given a set of features for NFT's for ex {"eyes": blue,green,yellow} , {"hair": black, brown, blue} . 
Combining this features to form unique NFT's. The further parts just built upon this with uniqueness constraints and having only limited NFT's with a given feature. 
Was straightforward and the round went well
 */

enum Color{
	GREEN,
	Yellow,
	RED
}

enum Length{
	SHORT,
	MEDIUM,
	TALL
}

class Tree{
	Color color;
	Length length;
	
	public Tree(Color color, Length length) {
		this.color = color;
		this.length = length;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Tree)) {
			return false;
		}
		Tree tree = (Tree) o;
		return tree.color == color && tree.length == length;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(color, length);
	}
	
	@Override
	public String toString() {
		return color.toString() + "@" + length.toString();
	}
}

class TreeBuilder{
	
	public List<Tree> randomObjects(List<Color> colorList, List<Length> lengthList, int numberOfObjects){
		List<Tree> treeList = new ArrayList<>();
		int i = 0;
		while(i < numberOfObjects) {
			Color color = colorList.get((int) (Math.random() * colorList.size()));
			Length length = lengthList.get((int) (Math.random() * lengthList.size()));
			treeList.add(new Tree(color, length));
			i++;
		}
		return treeList;
	}
	
	public List<Tree> randomUniqueObjects(List<Color> colorList, List<Length> lengthList, int numberOfObjects){
		if(numberOfObjects > colorList.size() * lengthList.size()) {
			throw new RuntimeException("Bad Input");
		}
		HashSet<Tree> treeSet = new HashSet<>();
		while(treeSet.size() < numberOfObjects) {
			Color color = colorList.get((int) (Math.random() * colorList.size()));
			Length length = lengthList.get((int) (Math.random() * lengthList.size()));
			treeSet.add(new Tree(color, length));
		}
		List<Tree> treeList = new ArrayList<>();
		for(Tree tree: treeSet) {
			treeList.add(tree);
		}
		return treeList;
	}
	
	public int randomIndex(List<Integer> cumList) {
		int random = (int) (Math.random() * cumList.get(cumList.size() - 1));
		int left = 0;
		int right = cumList.size() -1;
		while(right > left) {
			int mid = (right + left) / 2;
			if(cumList.get(mid) <= random) {
				left = right + 1;
			}
			else {
				right = mid;
			}
		}
		return right;
	}
	
	public List<Tree> randomUniqueObjectsWithWeights(List<Color> colorList, List<Length> lengthList, 
			List<Integer> colorWeights, List<Integer> lengthWeights, int numberOfObjects){
		if(numberOfObjects > colorList.size() * lengthList.size()) {
			throw new RuntimeException("Bad Input");
		}
		HashSet<Tree> treeSet = new HashSet<>();
		List<Integer> cumColorW = new ArrayList<>();
		List<Integer> cumLengthW = new ArrayList<>();
		int cum = 0;
		for(int cw: colorWeights) {
			cum += cw;
			cumColorW.add(cum);
		}
		cum = 0;
		for(int lw: lengthWeights) {
			cum += lw;
			cumLengthW.add(cum);
		}
		while(treeSet.size() < numberOfObjects) {
			Color color = colorList.get(randomIndex(cumColorW));
			Length length = lengthList.get(randomIndex(lengthWeights));
			treeSet.add(new Tree(color, length));
		}
		List<Tree> treeList = new ArrayList<>();
		for(Tree tree: treeSet) {
			treeList.add(tree);
		}
		return treeList;
	} 
	
}

public class RandomSelection {
	public static void main(String[] args) {
		List<Color> colorList = List.of(Color.GREEN, Color.RED, Color.Yellow);
		List<Length> lengthList = List.of(Length.MEDIUM, Length.SHORT, Length.TALL);
		TreeBuilder treeBuilder = new TreeBuilder();

		System.out.println(treeBuilder.randomObjects(colorList, lengthList, 6));
		System.out.println(treeBuilder.randomUniqueObjects(colorList, lengthList, 5));
		
		List<Integer> colorWeigths = List.of(1, 100, 100);
		List<Integer> lengthWeights = List.of(1, 10, 100);
		System.out.println(treeBuilder.randomUniqueObjectsWithWeights(colorList, lengthList, colorWeigths, lengthWeights, 3));
	}
}







































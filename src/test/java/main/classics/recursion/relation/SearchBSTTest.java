package main.classics.recursion.relation;

import main.TestBase;
import main.classics.recursion.relation.search_in_BST.SearchBST0;
import main.data_structures.TreeNode;
import org.junit.jupiter.api.Test;

public class SearchBSTTest extends TestBase
{
	@Test
	public void testSearchBST0()
	{
		int			expectedRootVal = 4;

		int			expectedLevelOneLeft = 2;
		int			expectedLevelOneRight = 7;

		int			expectedLevelTwoLeftLeft = 1;
		int			expectedLevelTwoLeftRight = 3;

		TreeNode 	expectedRoot = new TreeNode(expectedRootVal);

		TreeNode	expectedLevelOneLeftNode = new TreeNode(expectedLevelOneLeft);
		TreeNode	expectedLevelOneRightNode = new TreeNode(expectedLevelOneRight);

		TreeNode 	expectedLevelTwoLeftLeftNode = new TreeNode(expectedLevelTwoLeftLeft);
		TreeNode 	expectedLevelTwoLeftRightNode = new TreeNode(expectedLevelTwoLeftRight);

		// build tree
		//
		//				4
		//		2				7
		//	1		3

		expectedRoot.setLeft(expectedLevelOneLeftNode);
		expectedRoot.setRight(expectedLevelOneRightNode);

		expectedLevelOneLeftNode.setLeft(expectedLevelTwoLeftLeftNode);
		expectedLevelOneLeftNode.setRight(expectedLevelTwoLeftRightNode);

		SearchBST0 	searchBST0 = new SearchBST0();

		int			valueToSearch = 2;

		searchBST0.searchBST(expectedRoot, valueToSearch);

		assertEquals(expectedRoot, expectedRoot);
	}

	@Test
	public void testSearchBST1()
	{
		int			expectedRootVal = 4;

		int			expectedLevelOneLeft = 2;
		int			expectedLevelOneRight = 7;

		int			expectedLevelTwoLeftLeft = 1;
		int			expectedLevelTwoLeftRight = 3;

		TreeNode 	expectedRoot = new TreeNode(expectedRootVal);

		TreeNode	expectedLevelOneLeftNode = new TreeNode(expectedLevelOneLeft);
		TreeNode	expectedLevelOneRightNode = new TreeNode(expectedLevelOneRight);

		TreeNode 	expectedLevelTwoLeftLeftNode = new TreeNode(expectedLevelTwoLeftLeft);
		TreeNode 	expectedLevelTwoLeftRightNode = new TreeNode(expectedLevelTwoLeftRight);

		// build tree
		//
		//				4
		//		2				7
		//	1		3

		// search for 2, return sub tree, or null if it doesn't exist

		expectedRoot.setLeft(expectedLevelOneLeftNode);
		expectedRoot.setRight(expectedLevelOneRightNode);

		expectedLevelOneLeftNode.setLeft(expectedLevelTwoLeftLeftNode);
		expectedLevelOneLeftNode.setRight(expectedLevelTwoLeftRightNode);

		SearchBST0 	searchBST0 = new SearchBST0();

		int			valueToSearch = 2;

		TreeNode 	searchResult = searchBST0.searchBST(expectedRoot, valueToSearch);

		TreeNode 	expectedSearchNode = expectedLevelOneLeftNode;

		assertEquals(expectedSearchNode, searchResult);
	}
}

package main.easy.string_matching_array_1408;

import main.utils.Solution;
import main.utils.SolutionInput;

import java.util.List;

public abstract class StringMatchingArray implements Solution
{
	public Object execute(SolutionInput solutionInput)
	{
		String[] 	words = (String[]) solutionInput.getFirstInput();

		return stringMatchingArray(words);
	}

	abstract List<String> stringMatchingArray(String[] words);
}

package main.utils;

import java.util.LinkedList;
import java.util.List;

public final class Printer
{
	/**
	 * The list to collect objects to print.
	 */
	final private List<Object> itemsToPrint = new LinkedList<>();

	/**
	 * The token to print in between items e.g. 1 -> 2 -> 3 where the buffer token is " -> "
	 */
	final String bufferToken;

	/**
	 * The last result to be built, for replay-ability.
	 */
	String latestResultString;

	public Printer(String bufferToken)
	{
		this.bufferToken = bufferToken;
	}

	public void addItem(Object item)
	{
		itemsToPrint.add(item);
	}

	public void buildResultString()
	{
		StringBuilder resultBuilder = new StringBuilder();

		for (Object o : itemsToPrint)
		{
			resultBuilder.append(o.toString());
			resultBuilder.append(bufferToken);
		}

		// remove the final extra buffer token
		resultBuilder.setLength(resultBuilder.length() - bufferToken.length());

		latestResultString = resultBuilder.toString();
	}

	public void buildAndPrintResult()
	{
		buildResultString();

		System.out.println(latestResultString);
	}

	public String getLatestResultString()
	{
		return latestResultString;
	}
}

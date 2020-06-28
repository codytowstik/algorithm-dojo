package main.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class ComplexResultStringBuilder
{
	/**
	 * The list to collect objects to print.
	 */
	final private List<Object> itemsToPrint = new LinkedList<>();

	/**
	 * The list of lines to print.
	 */
	final private List<List<Object>> linesToPrint = new LinkedList<>();

	/**
	 * The token to print in between items e.g. 1 -> 2 -> 3 where the buffer token is " -> "
	 */
	final String bufferToken;

	/**
	 * The last result to be built, for replay-ability.
	 */
	String latestResultString;

	public ComplexResultStringBuilder(String bufferToken)
	{
		this.bufferToken = bufferToken;
	}

	/**
	 * Add item to the row, for printing tree-like structures in a beautiful format.
	 *
	 * @param item the item to add
	 */
	public void addItem(Object item)
	{
		itemsToPrint.add(item);
	}

	/**
	 * Increment the printing row, useful for printing tree-like objects (multi-level output)
	 */
	public void incrementRow()
	{
		// copy list
		List<Object>	currentLineItemsCopy = new ArrayList<>(itemsToPrint);

		linesToPrint.add(currentLineItemsCopy);

		// clear current items
		itemsToPrint.clear();
	}

	public void buildResultStringSingleLine()
	{
		StringBuilder 	resultBuilder = new StringBuilder();

		for (Object o : itemsToPrint)
		{
			resultBuilder.append(o.toString());
			resultBuilder.append(bufferToken);
		}

		// remove the final extra buffer token
		resultBuilder.setLength(resultBuilder.length() - bufferToken.length());

		latestResultString = resultBuilder.toString();
	}

	public void buildResultStringMultiLine()
	{
		StringBuilder 	resultBuilder = new StringBuilder();

		for (List<Object> line : linesToPrint)
		{
			for (Object itemToPrint : line)
			{
				resultBuilder.append(itemToPrint.toString());
				resultBuilder.append(bufferToken);
			}

			resultBuilder.append("\n");
		}

		latestResultString = resultBuilder.toString();
	}

	public void buildAndPrintResult()
	{
		buildResultStringSingleLine();

		System.out.println(latestResultString);
	}

	public String getLatestResultString()
	{
		return latestResultString;
	}
}

package main.classics.recursion.principle;

public class ReverseString0 extends ReverseString
{
	public void reverseString(char[] str)
	{
		char[] temp = new char[str.length];

		for (int i = 0; i < str.length; i++)
		{
			int reverseIndex = str.length - 1 - i;

			temp[i] = str[reverseIndex];
		}

		for (int i = 0; i < str.length; i++)
		{
			str[i] = temp[i];
		}
	}
}

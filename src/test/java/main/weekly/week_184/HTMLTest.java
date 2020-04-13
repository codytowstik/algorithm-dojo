package main.weekly.week_184;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HTMLTest
{
	@Test
	public void testHTML()
	{
		String text1 = "&amp; is an HTML entity but &ambassador; is not.";
		String output1 = "& is an HTML entity but &ambassador; is not.";

		String text2 = "and I quote: &quot;...&quot;";
		String output2 = "and I quote: \"...\"";

		boolean result1 = entityParser(text1).equals(output1);
		boolean result2 = entityParser(text2).equals(output2);

		assert result1;
		assert result2;
	}

	public String entityParser(String text)
	{
		Map<String,String> entityToReplacement = new HashMap<>(6);

		entityToReplacement.put("quot", "\"");
		entityToReplacement.put("apos", "'");
		entityToReplacement.put("amp", "&");
		entityToReplacement.put("gt", ">");
		entityToReplacement.put("lt", "<");
		entityToReplacement.put("frasl", "/");

		for (Map.Entry<String, String> entry : entityToReplacement.entrySet())
		{
			String	entity = entry.getKey();
			String	replacement = entry.getValue();

			text = text.replaceAll("&" + entity + ";", replacement);
		}

		return text;
	}

	public String entityParser2(String text)
	{
		Map<String,String> entityToReplacement = new HashMap<>(6);

		entityToReplacement.put("quot", "\"");
		entityToReplacement.put("apos", "'");
		entityToReplacement.put("amp", "&");
		entityToReplacement.put("gt", ">");
		entityToReplacement.put("lt", "<");
		entityToReplacement.put("frasl", "/");

		String[]		chars = text.split("");

		StringBuilder	resultBuilder = new StringBuilder();

		for (int i = 0; i < chars.length; i++)
		{
			String 	thisChar = chars[i];

			StringBuilder	entityBuilder = new StringBuilder();

			if (thisChar.equals("&"))
			{
				for (int j = i + 1; j < chars.length; j++)
				{
					int additionalChars = 0;
					String nextChar = chars[j];

					if (nextChar.equals(";"))
					{
						i += additionalChars;
						break;
					}
					else
					{
						entityBuilder.append(nextChar);
						additionalChars++;
					}
				}

				String	replacement = entityToReplacement.get(entityBuilder.toString());

				resultBuilder.append(replacement);

				// find entity replacement,
			}
			else
			{
				resultBuilder.append(thisChar);
			}
		}


		return resultBuilder.toString();
	}
}

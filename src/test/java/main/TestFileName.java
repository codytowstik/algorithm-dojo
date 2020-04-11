package main;

/**
 * Test file names.
 *
 * Enum naming scheme is
 *
 * For property files:
 *  input1_input2__output1
 *
 *  i.e. input1<underscore>input2<double_underscore>output1
 *
 * For failed input/output files:
 *   FAILED_(INPUT/EXPECTED/ACTUAL)_output
 */
public enum TestFileName
{
    ARRAYINT_INT__ARRAYINT( "arrayint-int_arrayint.properties"),
    ARRAYINT__LISTLISTINT( "ArrayInt_ListListInt.properties"),
    INT__BOOLEAN_PROPERTIES("int_boolean.properties"),
    INT__INT_PROPERTIES("simple.properties"),
    STRING__STRING_PROPERTIES("string_string.properties"),
    FAILED_ACTUAL_LISTLISTINT("failed_actual_ListListInt"),
    FAILED_EXPECTED_LISTLISTINT("failed_expected_ListListInt"),
    FAILED_INPUT_ARRAYINT("failed_input_ArrayInt");

    String fileName;

    TestFileName(String filename)
    {
        this.fileName = filename;
    }

    public String getFileName()
    {
        return "resources/" + fileName;
    }
}

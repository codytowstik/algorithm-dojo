package main.practice;

import main.practice.table_manufacturing.TableManufacturing0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Practice for Dematic.
 *
 *          Parts:
 *         final int REQUIRED_LEGS = 4;
 *         final int REQUIRED_TOPS = 1;
 *
 *         Assembly:
 *         final int REQUIRED_SCREWS = 6;
 *         final int REQUIRED_NUTS = 4;
 */
public final class TableManufacturingTest
{
    @Test
    public void tableManufacturingTest0()
    {
        // type model quantity
        String[] input0 = new String[]
                {
                        "Screws, L10, 16",
                        "Nuts, L10, 100",
                        "Legs, A10, 17",
                        "Tops, A10, 3",
                        "Legs, L10, 12",
                        "Tops, L10, 100",
                };

        String[] input1 = new String[]
                {
                        "Screws, L10, 1",
                        "Nuts, L10, 1",
                        "Legs, A10, 1",
                        "Tops, A10, 1",
                        "Legs, L10, 1",
                        "Tops, L10, 1",
                };

        // 0 - "Parts, A10, 3"
        // 1 - "Parts, L10, 3"
        // 2 - "Assembly, L10, 2"
        String[] solution1 = TableManufacturing0.solution(input0);

        Assertions.assertEquals(3, solution1.length);
        Assertions.assertEquals("Parts, A10, 3", solution1[0]);
        Assertions.assertEquals("Parts, L10, 3", solution1[1]);
        Assertions.assertEquals("Assembly, L10, 2", solution1[2]);

        // 0 - "None"
        String[] solution2 = TableManufacturing0.solution(input1);

        Assertions.assertEquals(1, solution2.length);

        Assertions.assertEquals("None", solution2[0]);
    }

    @Test
    public void tableManufacturingTest1()
    {
        // type model quantity
        String[] input0 = new String[]
                {
                        "Screws, L10, 16",
                        "Nuts, L10, 100",
                        "Legs, A10, 17",
                        "Tops, A10, 3",
                        "Legs, L10, 12",
                        "Tops, L10, 100",
                };

        String[] input1 = new String[]
                {
                        "Screws, L10, 1",
                        "Nuts, L10, 1",
                        "Legs, A10, 1",
                        "Tops, A10, 1",
                        "Legs, L10, 1",
                        "Tops, L10, 1",
                };

        TableManufacturing0.solution(input0);
    }
}

package main.practice;

import main.practice.table_manufacturing.TableManufacturing0;
import org.junit.jupiter.api.Test;

/**
 * Practice for Dematic.
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

        TableManufacturing0.solution(input0);
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

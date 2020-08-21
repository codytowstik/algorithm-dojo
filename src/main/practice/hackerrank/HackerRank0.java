package main.practice.hackerrank;

public class HackerRank0
{
    public static void solution()
    {
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(0, 0, 0);

        double d2 = p1.dist2D(p2);
        double d3 = p1.dist3D(p2);

        Point2D p = new Point2D(0, 0);
        p.printDistance(d2);
        p = p1;
        p.printDistance(d3);
    }

    static class Point2D
    {
        // stores value of x-coord
        int x;

        // stores value of y-coord
        int y;

        Point2D(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        /**
         * Calculates and returns the 2D distance between
         * two points (the current Point2d object and Point2D
         * param p.
         *
         * @param point2D the point to calculate distance between
         * @return the distance between the current point and the given point
         */
        double dist2D(Point2D point2D)
        {
            int x1 = this.x;
            int x2 = point2D.x;
            int y1 = this.y;
            int y2 = point2D.y;

            return Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
        }

        /**
         * Prints the 2D distance between two points as a 2D distance = k, where
         * k is distance d as a ceiling-rounded integer, on a new line.
         *
         * @param d the distance
         */
        void printDistance(double d)
        {
            System.out.println("2D distance = " + (int) Math.ceil(d));
        }
    }

    static class Point3D extends Point2D
    {
        // stores value of z-coord
        int z;

        Point3D(int x, int y, int z)
        {
            super(x, y);

            this.z = z;
        }

        /**
         * Calculates and returns the 3D distance between
         * two points (the current Point3D object and Point3D
         * param p.
         *
         * @param point3D the point to calculate distance between
         * @return the distance between the current point and the given point
         */
        double dist3D(Point3D point3D)
        {
            int x1 = this.x;
            int x2 = point3D.x;
            int y1 = this.y;
            int y2 = point3D.y;
            int z1 = this.z;
            int z2 = point3D.z;

            return Math.sqrt((Math.pow(x2 - x1, 2) +
                              Math.pow(y2 - y1, 2) +
                              Math.pow(z2 - z1, 2)));
        }

        /**
         * Prints the 3D distance between two points as a 2D distance = k, where
         * k is distance d as a ceiling-rounded integer, on a new line.
         *
         * @param d the distance
         */
        void printDistance(double d)
        {
            System.out.println("3D distance = " + (int) Math.ceil(d));
        }
    }
}

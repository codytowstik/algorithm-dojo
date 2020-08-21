package main.practice.hackerrank;

import java.text.MessageFormat;

/**
 * Hacker rank problem, poorly written. I don't even want to write it out cuz it makes me sad
 * Solved in ~30 minutes.
 *
 * Added student: John to the roll of class: 3
 * John obtained 61 marks in subject1
 * John obtained 12 marks in subject2
 * John obtained 38 marks in subject3
 * Added student: Smith to the roll of class: 8
 * Smith obtained 47 marks in subject1
 * Smith obtained 65 marks in subject2
 * Smith obtained 60 marks in subject3
 * Added student: Lenon to the roll of class: 7
 * Lenon obtained 59 marks in subject1
 * Lenon obtained 80 marks in subject2
 * Lenon obtained 84 marks in subject3
 * Added student: Mary to the roll of class: 2
 * Mary obtained 60 marks in subject1
 * Mary obtained 77 marks in subject2
 * Mary obtained 77 marks in subject3
 * Added student: Lily to the roll of class: 2
 * Lily obtained 85 marks in subject1
 * Lily obtained 66 marks in subject2
 * Lily obtained 28 marks in subject3
 * John has been promoted to class: 4
 * Smith has been promoted to class: 9
 * Lenon has been promoted to class: 8
 * Mary has been promoted to class: 3
 * Lily has been promoted to class: 3
 * John has ordered a recheck in subject1
 * Following is the new result: John has been promoted to class: 4
 * Lenon has ordered a recheck in subject1
 * Following is the new result: Lenon has been promoted to class: 8
 * Lily has ordered a recheck in subject1
 * Following is the new result: Lily has been promoted to class: 3
 */
public class HackerRank1
{
    public static void solution()
    {

    }

    static class Student
    {
        String name;
        int studentClass;
        float result;

        /**
         * Sets name of student to s and the class of the student to Class.
         * Prints resulting action.
         *
         * @param s student name
         * @param sClass student class
         */
        Student(String s, int sClass)
        {
            this.name = s;
            this.studentClass = sClass;

            System.out.println(MessageFormat.format(
                    "Added student: {0} to the roll of class: {1}",
                    this.name,
                    this.studentClass));
        }

        /**
         * Returns name of student.
         *
         * @return the student name
         */
        String getName()
        {
            return this.name;
        }

        /**
         * If result of student is greater than 33.33, prints student promoted or retained.
         *
         * @return
         */
        String publish()
        {
            String publishMessage;

            if (result > 33.33)
            {
                publishMessage = MessageFormat.format(
                        "{0} has been promoted to class: {1}",
                        this.name,
                        this.studentClass + 1);
            }
            else
            {
                publishMessage = MessageFormat.format(
                        "{0} has been retained in class: {1}",
                        this.name,
                        this.studentClass);
            }

//            System.out.println(publishMessage);
            return publishMessage;
        }
    }

    static class Result extends Student
    {
        int subject1;
        int subject2;
        int subject3;

        Result(int a, int b, int c, String s, int sClass)
        {
            super(s, sClass);

            this.subject1 = a;
            this.subject2 = b;
            this.subject3 = c;

            System.out.println(MessageFormat.format(
                    "{0} obtained {1} marks in subject1",
                    this.name,
                    this.subject1));

            System.out.println(MessageFormat.format(
                    "{0} obtained {1} marks in subject2",
                    this.name,
                    this.subject2));

            System.out.println(MessageFormat.format(
                    "{0} obtained {1} marks in subject3",
                    this.name,
                    this.subject3));
        }

        String calculateResult()
        {
            this.result = ((this.subject1 + this.subject2 + this.subject3) * 100) / 300f;

            return publish();
        }

        String changeMarks(int newMarks, String subject)
        {
            System.out.println(MessageFormat.format(
                    "{0} has ordered a recheck in {1}",
                    this.name,
                    subject));

            // assign new marks to the correct subject based on given parameter
            switch (subject)
            {
                case "subject1":
                {
                    subject1 = newMarks;
                    break;
                }

                case "subject2":
                {
                    subject2 = newMarks;
                    break;
                }

                case "subject3":
                {
                    subject3 = newMarks;
                    break;
                }
            }

            // calculate new result and return string
            return "Following is the new result: " + calculateResult();
        }
    }
}

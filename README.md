# Algorithm Dojo

### A framework for solving algorithmic problems, with the power of your IDE.

Online services like leetcode offer an online IDE that leaves you wishing for more power. Even with the premium
services, online IDEs just don't have the same flair.

Normally, if you want to start solving a new problem, you need to manually write out each test case.

You might find yourself with something like the following:

```java
int[] 	inputArr1 = new int[]{3, 1, 2, 1};
int 	m1 = 5;
int[]	output1 = new int[]{2,1,2,1};

int[] 	inputArr2 = new int[]{4, 1, 2, 2};
int 	m2 = 4;
int[] 	output2 = new int[]{3, 1, 2, 0};

int[] 	inputArr3 = new int[]{7, 5, 5, 8, 3};
int 	m3 = 8;
int[] 	output3 = new int[]{6,5,0,7,5};

boolean result1 = Arrays.equals(processQueries(inputArr1, m1), output1);
boolean result2 = Arrays.equals(processQueries(inputArr2, m2), output2);
boolean result3 = Arrays.equals(processQueries(inputArr3, m3), output3);

assert result1;
assert result2;
assert result3;
```
        
If you're smart, you might separate each of these test runs into separate test functions. The implemented function
is probably somewhere in the same file. This is usually fine for a one off. Once you start trying out multiple implementations,
things start to get messy and unorganized. Algorithm Dojo makes it easy.

## Usage

> Before you create a new problem, check [Problems.md](./Problems.md) for a list of existing problems and their signatures.

Let's suppose you're adding a new problem `ThreeSum` with the signature `List<List<Integer>> threeSum(int[] nums)`

1. Create a new package where it makes sense. For example, `package main.medium.threesum;`

2. Create a new `abstract class` that implements `Solution`. `Solution` provides the generic `execute` method
 the dojo uses to generically run each problem. Also define the signature for the problem you'll be solving.
 There are examples for each supported signature, see [Problems.md](./Problems.md) for a list of existing problems.
 
    ```java
    public abstract class ThreeSum implements Solution
    {
        public Object execute(SolutionInput input)
        {
            int[]	nums = (int[]) input.getFirstInput();
    
            return threeSum(nums);
        }
    
        abstract public List<List<Integer>> threeSum(int[] nums);
    }
    ```
        
3. Create a new property file in your new package called `input.properties` and add test cases to run against your
implementation. The input goes on the left, the output goes on the right. Multiple inputs are supported. The syntax
is defined in [InputOutputSyntax.md](./InputOutputSyntax.md).

4. Add a class that `extends` your new `abstract class` that defines the problem's signature, which will implement
your solution. *Create a new one of these for each implemented solution.*

    ```java
    public class ThreeSum0 extends ThreeSum
    {
        public List<List<Integer>> threeSum(int[] nums)
        {
            // for each number,
            //   for each other number with greater index,
            //     see if there is a value (with greater index) that sums us to zero
    
            List<List<Integer>> resultTriplets = new ArrayList<>();
    
            // ...
    
            return resultTriplets;
        }
    }
    ```
    
    

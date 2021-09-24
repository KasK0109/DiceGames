package piggame2;

public class DiceThrower {
    // 2 dice with face count of 6 each
    private Die die1, die2;

    // TODO: Add fields.
    // Fields:
    // 1. The roll count.
    // 2. The total of all face values rolled.
    // 3. The count of face value 6.
    // 4. The count of same face value on both dice.
    // 5. The maximum sum of the face values in one roll.
    // Remember to update fields, when the dice are rolled.
    private int rollCount;
    private int totalFaceValue;
    private int numberOfSixes;
    private int duplicates;
    private int maxSum;
    private int averageSum;

    /**
     * Creates a DiceThrower object.
     */
    // TODO: Make a constructor that initialises all fields.
    public DiceThrower() {
        this.die1 = new Die();
        // this.die2 = new Die();
        rollCount = 0;
        totalFaceValue = 0;
        numberOfSixes = 0;
        duplicates = 0;
        maxSum = 0;

    }

    // TODO: Add get methods for the fields.


    public int getRollCount() {
        return rollCount;
    }

    public int getTotalFaceValue() {
        return this.totalFaceValue;
    }

    public int getNumberOfSixes() {
        return numberOfSixes;
    }

    public int getDuplicates() {
        return duplicates;
    }

    public int getMaxSum() {
        return maxSum;
    }

    public int getAverageSum() {
        return averageSum;
    }

    /**
     * Rolls the 2 dice.
     */
    public void roll() {
        // TODO: Roll the 2 dice.
        die1.roll();
//        die2.roll();
        if (die1.getFaceValue() == 6) {
            numberOfSixes++;
        }
//        if (die2.getFaceValue() == 6) {
//            numberOfSixes++;
//        }
        rollCount++;

        if (maxSum < sum()) {
            maxSum = sum();
        }

        averageSum = totalFaceValue / rollCount;

//        if (die1.getFaceValue() == die2.getFaceValue()) {
//            duplicates++;
//        }

        totalFaceValue = totalFaceValue + (die1.getFaceValue());
    }

    /**
     * Returns the sum of the face values in a roll.
     */
    public int sum() {
        // TODO
        return die1.getFaceValue(); // + die2.getFaceValue();
    }

    /**
     * Returns a textual description of the roll of the 2 dice.
     * Example: Returns "(4,5)" for a roll of 4 and 5.
     */
    public String rollDescription() {
        // TODO: Use the method: String.format().
        String description = String.format(("(%d)"),die1.getFaceValue()); //, die2.getFaceValue());
        return description;
    }
}


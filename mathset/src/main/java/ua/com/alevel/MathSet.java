package ua.com.alevel;

import java.math.BigDecimal;

public class MathSet<N extends Number> {
    private static final Number[] EMPTY_NUMBERS = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Number[] numbers;

    public MathSet(){
        this.numbers = EMPTY_NUMBERS;
    }

    public MathSet(int capacity){
        if (capacity > 0) {
            this.numbers = new Number[capacity];
        } else if (capacity == 0) {
            this.numbers = EMPTY_NUMBERS;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }
    }

    public MathSet(Number[] numbers) {
        this.numbers = EMPTY_NUMBERS;
        add(numbers);
    }

    public MathSet(Number[] ... numbers) {
        this.numbers = EMPTY_NUMBERS;
        for (Number[] number : numbers) {
            add(number);
        }
    }

    public MathSet(MathSet mathSet) {
        this.numbers = EMPTY_NUMBERS;
        join(mathSet);
    }

    public MathSet(MathSet ... mathSets) {
        this.numbers = EMPTY_NUMBERS;
        join(mathSets);
    }

    private Number[] copyOf(Number[] oldArray, int size) {
        return copyOf(oldArray, 0 , size);
    }

    private Number[] copyOf(Number[] oldArray, int fromIndex, int size) {
        Number[] newArray = new Number[size];
        System.arraycopy(oldArray, fromIndex, newArray, 0, Math.min(oldArray.length, size));
        return newArray;
    }

    public boolean add(Number number) {
        add(number, numbers, size);
        return true;
    }


    public void add(Number ... numbers) {
        for (Number number : numbers) {
            if (number != null) {
                add(number);
            }
        }
    }

    private void add(Number number, Number[] numbers, int size) {
        if (size == numbers.length) {
            this.numbers = copyOf(this.numbers, this.size + newCapacity(size + 1));
        }
        this.numbers[size] = number;
        this.size = size + 1;
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = numbers.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (numbers == EMPTY_NUMBERS)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0)
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    public void join(MathSet mathSet) {
        for (Number newNumber : mathSet.toArray()) {
            if (!contains(newNumber)) {
                add(newNumber);
            }
        }
    }

    public void join(MathSet ... mathSets) {
        for(MathSet mathSet : mathSets){
            join(mathSet);
        }
    }

    public boolean contains(Number number) {
        return indexOf(number) >= 0;
    }

    public int indexOf(Number number) {
        return indexOfRange(number, 0, size);
    }

    int indexOfRange(Number o, int start, int end) {
        Number[] es = numbers;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void intersection(MathSet mathSet){
        Number[] substring = substring(mathSet.toArray());
        replace(substring);
    }

    public void intersection(MathSet ... mathSets){
        MathSet joinedMathSets = new MathSet(mathSets);
        intersection(joinedMathSets);
    }

    private Number[] substring(Number[] numbers){
        Number[] initialNumbers = toArray();
        int iterations = 0;
        for (Number newNumber : numbers) {
            if (contains(newNumber)) {
                add(newNumber);
                iterations++;
            }
        }
        Number[] substring = copyOf(toArray(), initialNumbers.length, iterations);
        replace(initialNumbers);
        return substring;
    }

    public void sortAsc(){
        sortAsc(toArray());
    }

    public void sortAsc(Number[] newArray){
        Number temp;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i+1; j < newArray.length; j++) {
                if(newArray[i].doubleValue() > newArray[j].doubleValue()) {
                    temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;;
                }
            }
        }
        replace(newArray);
    }

    public void sortAsc(int firstIndex, int lastIndex){
        if (firstIndex < 0 || lastIndex > size || firstIndex > lastIndex) return;
        sortAsc(copyOf(numbers, firstIndex, lastIndex));
    }

    public void sortDesc(){
        sortDesc(toArray());
    }

    public void sortDesc(Number[] newArray){
        Number temp;
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i+1; j < newArray.length; j++) {
                if(newArray[i].doubleValue() < newArray[j].doubleValue()) {
                    temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;;
                }
            }
        }
        replace(newArray);
    }

    public void sortDesc(int firstIndex, int lastIndex){
        if (firstIndex < 0 || lastIndex > size || firstIndex > lastIndex) return;
        sortDesc(copyOf(numbers, firstIndex, lastIndex));
    }

    public Number get(int index) {
        return numbers[index];
    }

    public Number getMax() {
        Number[] initialNumbers = toArray();
        sortDesc();
        Number maxNumber = this.numbers[0];
        replace(initialNumbers);
        return maxNumber;
    }

    public Number getMin() {
        Number[] initialNumbers = toArray();
        sortAsc();
        Number minNumber = this.numbers[0];
        replace(initialNumbers);
        return minNumber;
    }

    public Number getAverage() {
        BigDecimal sum = new BigDecimal(0);
        for (Number number : toArray()) {
            sum = sum.add(new BigDecimal(number.toString()));
        }
        return sum.divide(new BigDecimal(toArray().length));
    }

    public Number getMedian() {
        MathSet workMathSet = new MathSet(this);
        workMathSet.sortAsc();
        if (size == 0) {
            return null;
        } else if (size % 2 == 0) {
            BigDecimal first = new BigDecimal(workMathSet.toArray()[size / 2 - 1].toString());
            BigDecimal second = new BigDecimal(workMathSet.toArray()[size / 2].toString());
            return (first.add(second)).divide(new BigDecimal(2));

        }
        return workMathSet.toArray()[size / 2];
    }

    public Number[] toArray() {
        return copyOf(numbers, size);
    }
    public Number[] toArray(int firstIndex, int lastIndex) {
        return copyOf(numbers, firstIndex, lastIndex);
    }

    public MathSet cut(int firstIndex, int lastIndex){
        replace(copyOf(numbers, firstIndex, lastIndex));
        return this;
    }

    public void clear(){
        numbers = EMPTY_NUMBERS;
        size = 0;
    }

    public void clear(Number[] numbers) {
        for (Number number : numbers) {
            if (contains(number)) {
                this.numbers[indexOf(number)] = null;
            }
        }
        Number[] newArray = new Number[this.numbers.length];
        for (int i = 0; i < this.numbers.length; i++) {
            if (this.numbers[i] != null) {
                newArray[i] = this.numbers[i];
            }
        }

        replace(newArray);
    }

    private void replace(Number[] numbers){
        clear();
        add(numbers);
    }

    @Override
    public String toString() {
        return "[" + toString(toArray()) + "]";
    }

    private String toString(Number[] numbers){
        if(numbers == null || numbers.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; ; i++) {
            builder.append(numbers[i]);
            if (i == numbers.length - 1)
                return builder.toString();
            builder.append(", ");
        }
    }
}

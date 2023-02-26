package Question6;

import java.util.Comparator;
class MyComparator implements Comparator<Question6a.HuffmanNode> {
    public int compare(Question6a.HuffmanNode x, Question6a.HuffmanNode y) {
        return x.data - y.data;
    }
}
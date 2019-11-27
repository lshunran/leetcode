package leetcode.NO295;


class MedianFinderTest {

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        double p = mf.findMedian();
        System.out.println(p);
        mf.addNum(10);
         p = mf.findMedian();
        System.out.println(p);
        mf.addNum(2);
         p = mf.findMedian();
        System.out.println(p);
        mf.addNum(6);
         p = mf.findMedian();
        System.out.println(p);
        mf.addNum(5);
         p = mf.findMedian();
        System.out.println(p);
        mf.addNum(0);
         p = mf.findMedian();
        System.out.println(p);

        mf.addNum(6);
        p = mf.findMedian();
        System.out.println(p);
        mf.addNum(3);
        p = mf.findMedian();
        System.out.println(p);

        mf.addNum(1);
        p = mf.findMedian();
        System.out.println(p);
        mf.addNum(0);
        p = mf.findMedian();
        System.out.println(p);
        mf.addNum(0);
        p = mf.findMedian();
        System.out.println(p);
    }
}
import java.util.Arrays;

public class String_Search_字符串搜索 {

    /**
     * 类似 String indexOf()，底层如何实现？
     * 1.brutal force, time complexity O(n*m)
     *
     * 2. Rabin-Karp algorithm (基于hash算法) 优化，把字母转化成26个数字对应，
     * 每次挪动字母框的时候 减去第一位的数字 加上新读入数字 比较求和。hash算法的
     * 复杂度为O(N)，但是在极端情况，经常遇到同样hash值的比对，会退化成brutal force
     *
     * 3. Boyer-Moore Algorithm,
     * 坏字符规则：
     *      从右往左，找到第一个不匹配的字母，比如是A，就
     *      从模式串继续往走找到第一个A，进行两个A移动对齐。继续从最后面比对，重复移动对齐
     * 好后缀规则：
     *      在上一次的操作中，从右往左找直到不匹配，不匹配的点右侧全部的subfix被称为
     *      好后缀，从不匹配点往左看，找好后缀，移动与上面string的好后缀对齐
     *核心是减少移动的次数，两种综合都使用，看看哪一种移动的次数更多就用哪种
     *
     * O(N/M)最好情况，最坏情况 O(m*n)
     *
     * 4. KMP算法 终极算法
     *  定义：
     *      前缀: 字符串A和B A=B+S， B是A的前缀
     *      后缀: A=S+B， 则B是A的后缀
     *      PMT：前缀和后缀集合交集中，最长元素的长度值
     *      1.找到第一个不匹配
     *      2.找前面部分的交集，在移动过程中，就是拿前缀和后缀进行匹对
     *      3.对齐交集
     *          如何对齐，记录交集的长度，比如是2， 就把2赋值到当前不匹配的index
     *      4.next数组就是prefix数组往右移动了一位，0那个位置被-1填充
     *          next数组如何确定？本身就是通过前后缀求交集算出
     *          1.复制一份模式串
     *          2.再用kmp算法匹配一次 i=0, j=-1, next = -1，pmt=0
     *          3.匹配失败，j的值就赋值成next[j]，意味着要再往右一位
     *          4.当终于匹配到的时候, PMT = 1, next从-1加到0，每次匹配去上面的next值
     *          5.当j匹配失败的时候，当前index 找 对应 i在index的位置的next值 赋给next
     *          表示移动多少次
     *          6.结束条件是当原字符串被iterate 完
     *
     */

    /**
     *
     * @param pattern 模式串
     * @param next next数组用来控制移动多少位，传进来是空的
     */
    static void getNext(char [] pattern, int[] next){
        next[0] = -1;
        int i = 0, j = -1;
        // 控制条件：到模式串长度结束为止
        while (i< pattern.length){
            if (j == -1){
                i++;
                j++;
            }
            else if (pattern[i] == pattern[j]){
                i++; j++;
                next[i] = j;
            }
            else {
                j = next[j];
            }
        }
    }

    static int search (char[] str, char[] pattern, int[] next){
        int i = 0;
        int j = 0;
        while (i < str.length  && j < pattern.length){
            if (j == -1 || str[i] == pattern[j]){
                i++; j++;
            }
            else{
                j = next[j];
            }
        }
        if (j == pattern.length){
            return i - j;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String str1 = "ABCABCAABCABCD";
        String strPattern = "ABCABCD";
        int [] next = new int[strPattern.length()];
        // getNext does not return anything, but modify the next array
        getNext(strPattern.toCharArray(), next);
        int i = search(str1.toCharArray(), strPattern.toCharArray(), next);
        System.out.println(Arrays.toString(next));
        System.out.println(i);
        System.out.println(str1.indexOf(strPattern));
    }
}

public class CountPrime_埃筛法 {

    public static void main(String[] args) {
    }


    public static int eratosthenes(int n){
        boolean [] isPrime = new boolean[n]; //确定概念false代表质数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]){
                count++;
            }
            //编程技巧 j+=i，来控制2*i, 3*i, 4*i 遍历
            for (int j = 2*i; j<n; j+=i){
                isPrime[j] = true;
            }
        }
        return count;

    }

//    public static boolean isPrime(int x){
//        for (int i = 2; i*i <=x ; i++) {
//            if (x % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
}

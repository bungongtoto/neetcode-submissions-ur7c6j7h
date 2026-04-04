class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        for(int i = 0; i < arr.length; i++){
            for (int j = i + 1 ; j < arr.length; j++){
                int ax = Math.abs(arr[j] - x);
                int bx = Math.abs(arr[i] - x);
                if ( (ax < bx) || ((ax == bx) && (arr[j] < arr[i]))){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++){
            res.add(arr[i]);
        }

        Collections.sort(res);

        return res;
    }
}
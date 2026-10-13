class Point{
    int x;
    int y;
    double distance;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int[] getPoint(){
        return new int[]{this.x, this.y};
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        for (int[] point : points){

            maxHeap.offer(new Point(point[0], point[1]));

            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++){
            Point p = maxHeap.poll();

            res[i] = p.getPoint();
        }

        return res;
    }


}

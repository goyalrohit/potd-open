//Check If two Line segments Intersect
//Given the coordinates of the endpoints(p1,q1, and p2,q2) of the two line segments. Check if they intersect or not. If the Line segments intersect return true otherwise return false.
//Note: Please check the intersection lies within the line segments.

//Examples
//Input: p1=(1,1), q1=(10,1), p2=(1,2), q2=(10,2)
//Output: false
//Explanation:The two line segments formed by p1-q1 and p2-q2 do not intersect.

public class DoIntersect {

    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {
        // code here
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        if(o1 != o2 && o3 != o4) return "true";
        if(o1 == 0 && onSegment(p1, p2, q1)) return "true";
        if(o2 == 0 && onSegment(p1, p2, q1)) return "true";
        if(o3 == 0 && onSegment(p2, p1, q2)) return "true";
        if(o4 == 0 && onSegment(p2, p1, q2)) return "true";
        return "false";
    }
    int orientation(int p[], int q[], int r[]){
        long value = (long)(q[1]-p[1])*(r[0]-q[0]) - (long)(q[0]-p[0])*(r[1]-q[1]);
        if(value == 0) return 0;
        return (value > 0) ? 1 : 2;
    }
    boolean onSegment(int p[], int q[], int r[]){
        if(q[0] <= Math.max(p[0], r[0]) && q[0] >= Math.min(p[0], r[0]) &&
                q[1] <= Math.max(p[1], r[1]) && q[1] >= Math.min(p[1], q[1])) return true;
        return false;
    }

}

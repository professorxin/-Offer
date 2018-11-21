package Offer19;

import java.util.ArrayList;

public class Solution {
    /*题目描述
    输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
    如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.*/


    //牛客网高票答案
    /*
        思想，用左上和右下的坐标定位出一次要旋转打印的数据，一次旋转打印结束后，往对角分别前进和后退一个单位。
        提交代码时，主要的问题出在没有控制好后两个for循环，需要加入条件判断，防止出现单行或者单列的情况。
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        int top=0,bottom=matrix.length-1,left=0,right=matrix[0].length-1;
        //控制边界
        while(top<=bottom&&left<=right){
            //四个循环来遍历加入数组元素
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            for(int i=top+1;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            if(top!=bottom){
                for(int i=right-1;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
            }
            if(left!=right){
                for(int i=bottom-1;i>top;i--){
                    result.add(matrix[i][left]);
                }
            }
            top++;bottom--;left++;right--;
        }
        return result;
    }
}

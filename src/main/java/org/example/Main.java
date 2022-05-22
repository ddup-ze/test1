package org.example;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int n=sc.nextInt();
       int m=sc.nextInt();
       int[] nums=new int[n];
       for(int i=0;i<n;i++){
           nums[i]=sc.nextInt();
       }
    int res=minTime(nums,m);
        System.out.println(res);

    }
    public static int minTime(int[]nums,int m){
        Arrays.sort(nums);
        int l=0,h=nums.length-1;
        while(l<h){
            int tmp=nums[l];
            nums[l]=nums[h];
            nums[h]=tmp;
            l++;
            h--;
        }
        int left=nums[0],right=Arrays.stream(nums).sum();
        while(left<right){
            int mid=(left+right)/2;
            if(check(nums,m,mid)){
                right=mid;
            }else {
                left=mid+1;
            }

        }
        return left;
    }
    public static boolean check(int nums[],int m,int limit){
        int[] study=new int[m];
        return backtrack(nums,study,0,limit);
    }
    public static boolean backtrack(int[] nums,int[]study,int i,int limit){
        if(i>=nums.length) return true;
        int cur=nums[i];
        for(int j=0;j<study.length;j++){
            if(study[j]+cur<=limit){
                study[j]+=cur;
                if(backtrack(nums,study,i+1,limit)){
                    return true;
                }
                study[j]-=cur;
            }
            if(study[j]==0||study[j]+cur==limit){
                break;
            }
        }
        return false;
    }


}
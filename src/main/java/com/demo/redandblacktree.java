package com.demo;

import java.util.HashMap;

public class redandblacktree {
    final static int R=0;
    final static int B=1;
    boolean flag=true;
    node root=null;
    public static void main(String[] args) {

    }
  class node{
        int value;
        node left;
        node right;
        node parent;
        int color=R;
        node(int value){
            this.value=value;
        }


  }
  public  void insert(node n){
        node r=root;
        while(true){
            if(n.value>r.value){
               if(r.right==null){
                   r.right=n;
                   n.parent=r;
                   break;
               }
               r=r.right;
            } else{
                if(r.left==null){
                    r.left=n;
                    n.parent=r;
                    break;
                }
                r=r.left;
            }
        }
       ckeckandchange(n);

  }



    boolean ckeckandchange(node n){
        node grandp=n.parent.parent;
        if(grandp.right.color==R && grandp.left.color==R){
            if(grandp!=root){
                grandp.color=R;
                grandp.left.color=grandp.right.color=B;
            }else{
                grandp.left.color=grandp.right.color=B;
            }
            ckeckandchange(grandp);
        }
        return false;
  }



}
interface  sasd{
   final  int a=2;
   static int b=3;
   void method1();
   default void method2(){
       System.out.println("sad");
   }
}
class sss implements sasd{
    @Override
    public void method1() {

    }
}



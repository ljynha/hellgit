package com.realaxing;

import java.util.Random;

public class pso {

    public static void main(String[] args) {
        xy pbest[]=new xy[4];
        xy gbest=new xy();
        xy []xies=new xy[4];
        xy []vies=new xy[4];
        setpbest(pbest);
        setxies(xies);
        setvies(vies);
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <4 ; j++) {
                vies[i]=getvi(vies[i],xies[i],pbest[i],gbest);
                xies[i]=xyutils.addxy(xies[i],vies[i]);
                pbest[i]=getpbest(pbest[i],xies[i]);
            }
          gbest=getgbest(pbest);
        }
      }

    private static void setpbest(xy[] pbest) {
    }

    private static void setvies(xy[] vies) {
    }

    private static void setxies(xy[] xies) {
    }



    private static xy getgbest(xy[] pbest) {
     return getpbest(getpbest(pbest[0],pbest[1]),getpbest(pbest[0],pbest[1]));
    }

    private static xy getpbest(xy xy, xy xy1) {
     if(f(xy.getX(),xy.getY())<f(xy1.getX(),xy1.getY())){
         return  xy;
     }else{
         return xy1;
     }
    }

    private static xy getvi(xy vy, xy xy, xy pbest, xy gbest) {
        xy v=new xy();
        double w=0.5;
      double c1=2,c2=2,r1,r2;
        Random random=new Random();
        r2=r1=random.nextDouble();
        vy=xyutils.mulxy(w,vy);
        vy=xyutils.addxy(vy,xyutils.mulxy(r1*c1,xyutils.subxy(pbest,xy)));
        v= xyutils.addxy(vy,xyutils.mulxy(r2*c2,xyutils.subxy(gbest,xy)));
        if(v.getX()>0.5){
            v.setX(0.5);
        }
        if(v.getX()<-0.5){
            v.setX(0.5);
        }
        if(v.getY()>0.5){
            v.setY(0.5);
        }
        if(v.getY()<-0.5){
            v.setY(0.5);
        }
        return v;
    }

    public  static double f(double x,double y){
        return x*x+y*y;
    }
    }
    class xy{
    double x;
    double y;

        public xy() {
        }

        public xy(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    class xyutils{
    public static xy addxy(xy o1,xy o2){
        return new xy(o1.getX()+o2.getX(),o1.getY()+o2.getY());
    }
        public static xy subxy(xy o1,xy o2){
            return new xy(o1.getX()-o2.getX(),o1.getY()-o2.getY());
        }
        public static xy mulxy(double d,xy x){
        return new xy(x.getX()*d,x.getY()*d);
        }
    }




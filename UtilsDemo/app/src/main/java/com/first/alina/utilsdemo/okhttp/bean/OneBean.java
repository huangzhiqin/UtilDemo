package com.first.alina.utilsdemo.okhttp.bean;

import java.util.List;

public class OneBean {
    public Result result;

   public class Result {

        public List<Android> Android;

       @Override
       public String toString() {
           return "Result{" +
                   "Android=" + Android +
                   '}';
       }
   }

   public class Android {
        public String _id;
        public String desc;

       @Override
       public String toString() {
           return "Android{" +
                   "_id='" + _id + '\'' +
                   ", desc='" + desc + '\'' +
                   '}';
       }
   }

    @Override
    public String toString() {
        return "OneBean{" +
                "results=" + result +
                '}';
    }
}

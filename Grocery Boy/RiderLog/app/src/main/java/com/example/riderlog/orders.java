package com.example.riderlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class orders {

    public String department, superDepartment, title;

    public orders()
    {

    }

    public orders(String department, String title){

        this.department = department;
       // this.superDepartment = superDepartment;
        this.title = title;
    }

    public String getDepartment(){return department;}
   // public String getSuperDepartment(){return superDepartment;}
    public String getTitle(){return title;}


    public void setDepartment(String department) {
        this.department = department;
    }

 //   public void setSuperDepartment(String superDepartment) {
   //     this.superDepartment = superDepartment;
   // }

    public void setTitle(String title) {
        this.title = title;
    }


}
